package ru.stqa.pft.classes;

import static java.lang.Math.sqrt;

/**
 * Базовый класс для представления точек на двумерной плоскости
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 21.02.2022
 */

public class Point {

    // Поля класса
    private double x;
    private double y;

    // Конструктор класса
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Геттеры
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    // Метод, вычисляющий расстояние между двумя точками d = √((хА – хВ)^2 + (уА – уВ)^2)
    public static double getDistance(Point p1, Point p2) {

        double deltaX = p1.getX() - p2.getX();
        double deltaY = p1.getY() - p2.getY();
        double distance = sqrt(deltaX * deltaX + deltaY * deltaY);

        return distance;
    }
}
