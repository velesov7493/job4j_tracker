package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(in, out);
        int selected = input.askInt("Enter menu:");
        assertEquals(1, selected);
    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-50"}
        );
        ValidateInput input = new ValidateInput(in, out);
        int selected = input.askInt("Enter menu:");
        assertEquals(-50, selected);
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"40"}
        );
        ValidateInput input = new ValidateInput(in, out);
        int selected = input.askInt("Enter menu:");
        assertEquals(40, selected);
    }

    @Test
    public void whenMultiInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "2", "3", "5", "8", "13", "21", "34", "55"}
        );
        ValidateInput input = new ValidateInput(in, out);
        int[] expected = {1, 2, 3, 5, 8, 13, 21, 34, 55};
        int[] result = new int[9];
        for (int i = 0; i < 9; i++) {
            result[i] = input.askInt("Enter number:");
        }
        assertArrayEquals(expected, result);
    }

}