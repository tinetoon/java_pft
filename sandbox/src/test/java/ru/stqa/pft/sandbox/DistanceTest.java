package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.classes.Distance;
import ru.stqa.pft.classes.Point;

/**
 * Класс для тестирования класса Distance
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 21.02.2022
 */

public class DistanceTest {

    @Test
    public void testDistance() {

        double x1 = -3;
        double y1 = 1.5;
        double x2 = 3;
        double y2 = 1.5;

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);

        Distance distance = new Distance();
//        assert distance.getDistance(p1, p2) == 6.0;
        Assert.assertEquals(distance.getDistance(p1, p2), 6.0);
    }
}
