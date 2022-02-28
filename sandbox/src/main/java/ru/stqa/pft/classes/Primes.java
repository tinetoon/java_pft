package ru.stqa.pft.classes;

/**
 * Базовый класс для определения простого числа
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 28.02.2022
 */

public class Primes {

    public static boolean isPrime(int value) {

        for (int i = 2; i < value; i++) {

            if ((value % i) == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPrime(long value) {

        for (long i = 2; i < value; i++) {

            if ((value % i) == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPrimeWhile(int value) {

        int i = 2;

        while (i < value && value % i == 0) {
            i++;
        }

        return (i == value);
    }

    public static boolean isPrimeHalf(int value) {

        for (int i = 2; i < (value / 2); i++) {

            if ((value % i) == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPrimeSqrt(int value) {

        int valueSqrt = (int) Math.sqrt(value);

        for (int i = 2; i < valueSqrt; i++) {

            if ((value % i) == 0) {
                return false;
            }
        }

        return true;
    }
}
