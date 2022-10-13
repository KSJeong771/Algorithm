package reusable;

import java.util.*;

public class Convert {

    public int[] to1dArray(List<Integer> list) {
        return list.stream()
                .mapToInt(i->i)
                .toArray();
    }

    public char[][] to2dArray(String[] grid) {
        int height = grid.length;
        int width = grid[0].length();

        char[][] arrGrid = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arrGrid[i][j]=  grid[i].charAt(j);
            }
        }

        return arrGrid;
    }
}
