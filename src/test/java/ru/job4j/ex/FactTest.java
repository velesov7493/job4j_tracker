package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenIAE() {
        Fact.calc(-33);
    }

    @Test
    public void when4Then24() {
        int expected = 24;
        int result = Fact.calc(4);
        assertEquals(expected, result);
    }

}