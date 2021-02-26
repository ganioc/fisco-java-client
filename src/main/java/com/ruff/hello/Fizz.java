package com.ruff.hello;

public class Fizz {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(convert(i));
        }
    }

    public static String convert(int fizzBuzz) {
        if (fizzBuzz % 15 == 0) {
            return "FizzBuzz";
        }
        if (fizzBuzz % 3 == 0) {
            return "Fizz";
        }
        if (fizzBuzz % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(fizzBuzz);
    }
}
