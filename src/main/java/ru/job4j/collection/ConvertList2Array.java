package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {

    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        int[][] array = new int[groups][cells];
        int row = 0, col = 0;
        for (Integer num : list) {
            array[row][col++] = num;
            if (col == cells) {
                col = 0;
                row++;
            }
        }
        return array;
    }
}
