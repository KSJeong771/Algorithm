package reusable;

import java.util.*;
import java.util.stream.Collectors;

public class Converter {

    public List<Character> str2list(String str) {
        return str.chars()
                .mapToObj(i -> (char)i)
                .collect(Collectors.toList());
    }

    public int[] list2Array(List<Integer> list) {
        return list.stream()
                .mapToInt(i->i)
                .toArray();
    }

    public char[][] str2Matrix(String[] grid) {
        int height = grid.length;
        int width = grid[0].length();

        char[][] matrix = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = grid[i].charAt(j);
            }
        }

        return matrix;
    }
}
