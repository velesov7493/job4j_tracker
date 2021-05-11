package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                result = i;
                break;
            }
        }
        if (result < 0) {
            throw new ElementNotFoundException("Элемент массива не найден");
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"one", "two", "three", "four"};
        try {
            int i = indexOf(strings, "five");
        } catch (ElementNotFoundException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }

    }
}
