package ru.stqa.pft.classes;

/**
 * Базовый класс для вычисления корней квадратного уравнения
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 25.02.2022
 */

public class Equation {

    // Поля класса
    private double a;
    private double b;
    private double c;

    private int n;

    // Конструктор
    public Equation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

        double d = b * b - 4 * a * c;

        if (d > 0) {
            n = 2;
        } else {
            if (d == 0) {
                n = 1;
            } else {
                n = 0;
            }
        }
    }

    public int rootNumber() {
        return n;
    }
}
