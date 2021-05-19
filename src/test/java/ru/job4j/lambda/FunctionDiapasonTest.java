package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FunctionDiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionDiapason.calc(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = FunctionDiapason.calc(0, 5, x -> 0.5 * Math.pow(x, 2) + x + 1);
        List<Double> expected = Arrays.asList(1D, 2.5D, 5D, 8.5D, 13D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenQuadraticResults() {
        List<Double> result = FunctionDiapason.calc(0, 5, x -> Math.pow(2, x) + x);
        List<Double> expected = Arrays.asList(1D, 3D, 6D, 11D, 20D);
        assertThat(result, is(expected));
    }
}