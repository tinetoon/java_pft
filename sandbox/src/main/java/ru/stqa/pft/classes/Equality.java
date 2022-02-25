package ru.stqa.pft.classes;

/**
 * Базовый класс для сравнения значений
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 25.02.2022
 */

public class Equality {

    public static void main(String[] args) {

        String s1 = "firefox";
//        String s2 = s1; // новый объект не создаётся, обе переменные ссылаются на один и тот же объект
//        String s2 = new String(s1);
        String s2 = "firefox";

        System.out.println("s1 == s2: " + (s1 == s2)); // сравнение ссылок
        System.out.println("s1.equals(s2): " + (s1.equals(s2)));
    }
}
