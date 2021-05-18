package ru.job4j.collection.departments;

import java.util.Comparator;

public class DepartmentsDescComp implements Comparator<String> {

    /**
     * Разделение последовательности на голову и хвост
     * Часть codeSequence до символа "/" - голова, а после - хвост
     * @param codeSequence разделяемая последовательность
     * @return Массив из 2-х строк. [0] - голова, [1] - хвост.
     */
    private String[] headTail(String codeSequence) {
        String[] result = new String[2];
        int i = codeSequence.indexOf('/');
        if (i < 0) {
            result[0] = codeSequence;
            result[1] = "";
            return result;
        }
        result[0] = codeSequence.substring(0, i);
        result[1] = codeSequence.substring(i + 1);
        return result;
    }

    @Override
    public int compare(String left, String right) {
        String[] chunks1 = headTail(left);
        String[] chunks2 = headTail(right);
        int result = chunks2[0].compareTo(chunks1[0]);
        if (result != 0) {
            return result;
        }
        result = chunks1[1].compareTo(chunks2[1]);
        return result;
    }
}
