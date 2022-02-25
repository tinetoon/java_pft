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

        /*if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("INFO: a,b,c=0 - beskonechnoe kol-vo reshenij");
                    n = -1;
                } else {
                    System.out.println("INFO: a,b=0, c=/=0 - net reshenij");
                    n = 0;
                }
            } else {
                System.out.println("INFO: a=0 - eto vjrozhdennoe linejnoe uravnenie");
                n = 1;
            }
        } else {
            if (d > 0) {
                n = 2;
            } else if (d == 0) {
                n = 1;
            } else {
                n = 0;
            }
        }*/

        if (a != 0) {
            if (d > 0) {
                n = 2;
            } else if (d == 0) {
                n = 1;
            } else {
                n = 0;
            }

        } else {
            if (b != 0) {
                System.out.println("INFO: a=0 - eto vjrozhdennoe linejnoe uravnenie");
                n = 1;

            } else if (c != 0) {
                System.out.println("INFO: a,b=0, c=/=0 - net reshenij");
                n = 0;

            } else {
                System.out.println("INFO: a,b,c=0 - beskonechnoe kol-vo reshenij");
                n = -1;
            }
        }

        // Вложенная форма if-else
        /*if (d > 0) {
            n = 2;
        } else {
            if (d == 0) {
                n = 1;
            } else {
                n = 0;
            }
        }*/

        // Свёрнутая форма if-else
        /*if (d > 0) {
            n = 2;
        } else if (d == 0) {
            n = 1;
        } else {
            n = 0;
        }*/

    }

    public int rootNumber() {
        return n;
    }
}
