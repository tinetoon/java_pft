package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.classes.Equation;

/**
 * Класс для тестирования класса Equation
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 25.02.2022
 */

public class EquationTest {

    @Test(description = "Количество решений при отрицательном дискриминанте")
    public void zeroQuadraticRootsTest() {
        Equation e = new Equation(1, 1, 1);
        Assert.assertEquals(e.rootNumber(), 0);
    }

    @Test(description = "Количество решений при нулевом дискриминанте")
    public void oneQuadraticRootsTest() {
        Equation e = new Equation(1, 2, 1);
        Assert.assertEquals(e.rootNumber(), 1);
    }

    @Test(description = "Количество решений при положительном дискриминанте")
    public void twoQuadraticRootsTest() {
        Equation e = new Equation(1, 5, 6);
        Assert.assertEquals(e.rootNumber(), 2);
    }

    @Test(description = "Уравнение вырождается в линейное")
    public void linearTest() {
        Equation e = new Equation(0, 1, 1);
        Assert.assertEquals(e.rootNumber(), 1);
    }

    @Test(description = "Уравнение вырождается в константу")
    public void constantTest() {
        Equation e = new Equation(0, 0, 1);
        Assert.assertEquals(e.rootNumber(), 0);
    }

    @Test(description = "Уравнение вырождается в бесконечность")
    public void infinityTest() {
        Equation e = new Equation(0, 0, 0);
        Assert.assertEquals(e.rootNumber(), -1);
    }
}
