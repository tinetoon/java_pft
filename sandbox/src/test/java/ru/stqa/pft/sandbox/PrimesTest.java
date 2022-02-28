package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.classes.Primes;

/**
 * Класс для тестирования класса Primes
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 28.02.2022
 */

public class PrimesTest {

    @Test(enabled = false)
    public void testPrimePositive() {

        Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
    }

    @Test
    public void testPrimeHalfPositive() {

        Assert.assertTrue(Primes.isPrimeHalf(Integer.MAX_VALUE));
    }

    @Test
    public void testPrimeSqrtPositive() {

        Assert.assertTrue(Primes.isPrimeSqrt(Integer.MAX_VALUE));
    }

    @Test
    public void testPrimeNegative() {

        Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE-2));
    }

    @Test(enabled = false) // enabled = false - отключение теста
    public void testPrimeLongPositive() {

        long longValue = Integer.MAX_VALUE;

        Assert.assertTrue(Primes.isPrime(longValue));
    }
}
