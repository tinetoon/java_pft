package ru.stqa.pft.classes;

import static java.lang.Math.sqrt;

/**
 * Базовый класс для вычисления расстояния между двумя точками
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 21.02.2022
 */

public class Distance {

    public static void main(String[] args) {

        double x1 = -3;
        double y1 = 1.5;
        double x2 = 3;
        double y2 = 1.5;

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);

        // Using the getDistance function of the current class
        double resultDistance = getDistance(p1, p2);

        System.out.println("Расстояние между точками р1 и р2 равно: " + resultDistance);

        // Using the getDistance method of the Point class
        double resultDistanceMethod = Point.getDistance(p1, p2);

        System.out.println("Сравнение равенства результатов вычисления расстояния между функцией и методом: "
                            + (resultDistanceMethod == resultDistance));
    }

    // Функция, вычисляющий расстояние между двумя точками d = √((хА – хВ)^2 + (уА – уВ)^2)
    public static double getDistance(Point p1, Point p2) {

        double deltaX = p1.getX() - p2.getX();
        double deltaY = p1.getY() - p2.getY();

        return sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
