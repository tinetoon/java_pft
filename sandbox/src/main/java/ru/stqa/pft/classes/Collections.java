package ru.stqa.pft.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Базовый класс для изучения коллекций
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 28.02.2022
 */

public class Collections {

    public static void main(String[] args) {

        System.out.println("========== Array ==========");

        /*String[] langsArray = new String[4];

        langsArray[0] = "java";
        langsArray[1] = "C#";
        langsArray[2] = "Python";
        langsArray[3] = "PHP";*/

        String[] langsArray = {"java", "C#", "Python", "PHP"};

        /*for (int i = 0; i < langsArray.length; i++) {

            System.out.println("Элемент массива " + (i + 1) + " : " + langsArray[i]);
        }*/

        for (String l : langsArray) {

            System.out.println("Я хочу выучить: " + l);
        }

        System.out.println("========== ArrayList ==========");

        /*List<String> langsArrayList = new ArrayList<>();

        langsArrayList.add("java");
        langsArrayList.add("C#");
        langsArrayList.add("Python");
//        langsArrayList.add("PHP");*/

        List<String> langsArrayList = Arrays.asList("java", "C#", "Python");
//        List<String> langsArrayList = Arrays.asList(langsArray);

        /*for (int i = 0; i < langsArrayList.size(); i++) {

            System.out.println("Я хочу выучить: " + langsArrayList.get(i));
        }*/

        for (String l : langsArrayList) {

            System.out.println("Я хочу выучить: " + l);
        }

    }
}
