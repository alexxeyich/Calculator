package Test;

/*
1) Калькулятор выполняет операции  a + b, a - b, a * b, a / b. Данные в калькулятор передаются в одну строку.
2) Калькулятор работает с арабскими и римскими числами.
3) Калькулятор работает на ввод в диапозоне [1;10]. На вывод не ограничен.
4) Калькулятор работет только с целыми числами.
5) Калькулятор работает только с римскими или только с арабскими числами.
6) При вводе римских чисел ответ долже быть в римских числах, при вводе арабских – ответ арабскими.
*/

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static Converter converter = new Converter();

    public static int addition(String input) { // Операция сложения для арабских чисел
        String[] result = input.split("\\+");
        return Integer.parseInt(result[0]) + Integer.parseInt(result[1]);
    }

    public static int subtraction(String input) { // Операция вычитания для арабских чисел
        String[] result = input.split("\\-");
        return Integer.parseInt(result[0]) - Integer.parseInt(result[1]);
    }

    public static int multiplication(String input) { // Операция умножения для арабских чисел
        String[] result = input.split("\\*");
        return Integer.parseInt(result[0]) * Integer.parseInt(result[1]);
    }

    public static int division(String input) { // Операция деления для арабских чисел
        String[] result = input.split("\\/");
        return Integer.parseInt(result[0]) / Integer.parseInt(result[1]);
    }

    public static void main(String[] args) {

        System.out.println("Введите числа в формате: a+b, a-b, a*b, a/b");
        Input expression = new Input(); // Ввод данных пользователем

        Pattern roman = Pattern.compile("^I\\W|^II\\W|^III\\W|^IV\\W|^V\\W|^VI\\W|^VII\\W|^VIII\\W|^IX\\W|^X\\W|\\WI$|\\WII$|\\WIII$|\\WIV$|\\WV$|\\WVI$|\\WVII$|\\WVIII$|\\WIX$|\\WX$");
        Matcher Roman = roman.matcher(expression.input);

        Pattern arabic = Pattern.compile("^10\\W[1-9]$|^[1-9]\\W10$|^10\\W+10$|^[1-9]\\W[1-9]$");
        Matcher Arabic = arabic.matcher(expression.input);

        Pattern addition = Pattern.compile("\\+");
        Matcher Addition = addition.matcher(expression.input);

        Pattern subtraction = Pattern.compile("\\-");
        Matcher Subtraction = subtraction.matcher(expression.input);

        Pattern multiplication = Pattern.compile("\\*");
        Matcher Multiplication = multiplication.matcher(expression.input);

        Pattern division = Pattern.compile("\\/");
        Matcher Division = division.matcher(expression.input);

        if (Arabic.find() == true) { // Калькулятор арабских чисел
            if (Addition.find() == true) // Операция сложения
                System.out.println(addition(expression.input)); // Результат

            else if (Subtraction.find() == true) // Операция вычитания
                System.out.println(subtraction(expression.input)); // Результат

            else if (Multiplication.find() == true) // Операция умножения
                System.out.println(multiplication(expression.input)); // Результат

            else if (Division.find() == true) // Операция деления
                System.out.print(division(expression.input)); // Результат

        } else if (Roman.find() == true) { // Калькулятор римских чисел
            Main main = new Main();

            if (Addition.find() == true) { // Операция сложения
                String[] result = expression.input.split("\\+");

                if (converter.isRoman(result[0]) == converter.isRoman(result[1])) { // Условие соответсвия двух чисел одной системе счисления
                    int a = main.romanToInt(result[0]);
                    int b = main.romanToInt(result[1]);

                    if (a <= 10 & a > 0 & b <= 10 & b > 0) {
                        System.out.println(main.intToRoman(a + b)); // Результат
                    }
                } else System.out.println("Калькулятор принимает только только ДВА ЧИСЛА из одной системы счисления в диапозоне [1;10]");

            } else if (Subtraction.find() == true) { // Операция вычитания
                String[] result = expression.input.split("\\-");

                if (converter.isRoman(result[0]) == converter.isRoman(result[1])) { // Условие соответсвия двух чисел одной системе счисления
                    int a = main.romanToInt(result[0]);
                    int b = main.romanToInt(result[1]);

                    if (a <= 10 & a > 0 & b <= 10 & b > 0) {
                        System.out.println(main.intToRoman(a - b)); // Результат
                    }
                } else System.out.println("Калькулятор принимает только только ДВА ЧИСЛА из одной системы счисления в диапозоне [1;10]");

            } else if (Multiplication.find() == true) { // Операция умножения
                String[] result = expression.input.split("\\*");

                if (converter.isRoman(result[0]) == converter.isRoman(result[1])) { // Условие соответсвия двух чисел одной системе счисления
                    int a = main.romanToInt(result[0]);
                    int b = main.romanToInt(result[1]);

                    if (a <= 10 & a > 0 & b <= 10 & b > 0) {
                        System.out.println(main.intToRoman(a * b)); // Результат
                    }
                } else System.out.println("Калькулятор принимает только только ДВА ЧИСЛА из одной системы счисления в диапозоне [1;10]");

            } else if (Division.find() == true) { // Операция деления
                String[] result = expression.input.split("\\/");

                if (converter.isRoman(result[0]) == converter.isRoman(result[1])) { // Условие соответсвия двух чисел одной системе счисления
                    int a = main.romanToInt(result[0]);
                    int b = main.romanToInt(result[1]);

                    if (a <= 10 & a > 0 & b <= 10 & b > 0) {
                        System.out.println(main.intToRoman(a / b)); // Результат
                    }
                } else System.out.println("Калькулятор принимает только только ДВА ЧИСЛА из одной системы счисления в диапозоне [1;10]");
            }

        } else System.out.println("Калькулятор принимает только только ДВА ЧИСЛА из одной системы счисления в диапозоне [1;10]");
    }

    static class Input { // Конструктор ввода данных пользователем
        Scanner in = new Scanner(System.in);
        String input;

        Input() {
            input = in.nextLine();
        }
    }

    public int romanToInt(String s) { // Map для римских цифр введенных пользователем
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int end = s.length()-1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = map.get(arr[end]);
        for (int i = end-1; i >= 0; i--) {
            arabian = map.get(arr[i]);

            if (arabian < map.get(arr[i+1])) {
                result -= arabian;

            } else {
                result += arabian;
            }
        }
        return result;
    }

    public String intToRoman(int number) { // Map для римских чисел при выводе результата
        TreeMap<Integer,String> map = new TreeMap<>();
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        String roman = "";
        int arabian;

        do {
            arabian = map.floorKey(number);
            roman += map.get(arabian);
            number -= arabian;
        } while (number != 0);

        return  roman;
    }

    public static class Converter { // Map для выставления условия соответсвия двух чисел одной системе счисления
        TreeMap<Character, Integer> map = new TreeMap<>();

        public Converter() {
            map.put('I',1);
            map.put('V',5);
            map.put('X',10);
            map.put('L',50);
            map.put('C',100);
            map.put('D',500);
            map.put('M',1000);
        }

        public boolean isRoman(String number) {
            return map.containsKey(number.charAt(0));
        }
    }
}

