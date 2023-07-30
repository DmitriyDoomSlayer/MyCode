import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.SplittableRandom;

public class Main {

    public static String calc(String input, String[] bol) throws Exception {
        String[] inputs = input.split(" ");
        if (inputs.length != 3) try {
            throw new Exception("Ошибка");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String firstNumber = inputs[0];
        String operand = inputs[1];
        String secondNumber = inputs[2];

        boolean ifArabian = false;
        try {
            Integer.parseInt(firstNumber);
            ifArabian = true;
        }
        catch (Exception e) {
            /*System.out.println(" Не удалось преобразовать строку в число");*/
        }
        int one = 0;
        int two = 0;
        if (ifArabian == true) {
            one = Integer.parseInt(firstNumber);
            two = Integer.parseInt(secondNumber);
        } else {
            one = romanToArab(firstNumber);
            two = romanToArab(secondNumber);
        }

        if (one > 10 || one < 1){
            throw new Exception("Ведите число от 1 до 10");
        } else if (two <1 || two > 10){
            throw new Exception("Ведите число от 1 до 10");
        }

        int result = 0;

        switch (operand) {
            case "+":
                result = one + two;
                break;
            case "-":
                result = one - two;
                break;
            case "/":
                result = one / two;
                break;
            case "*":
                result = one * two;
                break;
        }

        String res = Integer.toString(result);
        if (ifArabian == false) {
           res = arabToRoman(result, bol);
        }
        return res;
    }



    public static int romanToArab (String roman) throws Exception {

        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (Exception e) {
            throw new Exception("Неверный формат данных");
        }
     throw new Exception("Неверный формат данных");
    }


    public static String arabToRoman(int arab, String[] romanNumbersMassiv) {

        String a = romanNumbersMassiv[arab - 1];
        return a;
    }

    public static void main(String[] args) {

        String[] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI",
                "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI",
                "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII",
                "XCIX", "C"};
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();


        try {
            System.out.println(calc(input, romanNumbers));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


}