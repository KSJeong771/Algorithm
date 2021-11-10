//https://programmers.co.kr/learn/courses/30/lessons/77485

import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] min = new int[queries.length];
        int minIndex = 0;
        
        int[][] array = createArray(rows, columns);
        for(var q : queries){
            ArrayList<Integer> line = rectToLine(array, q[0]-1, q[1]-1, q[2]-1, q[3]-1);
            lineToRotatedRect(array, line, q[0]-1, q[1]-1, q[2]-1, q[3]-1);
            min[minIndex++] = getMinFromLine(line);
        }
        
        return min;
    }
    
    public ArrayList<Integer> rectToLine(int[][] array, int y1, int x1, int y2, int x2){
        int x;
        int y;
        ArrayList<Integer> line = new ArrayList<Integer>();
        for(x=x1, y=y1; x<x2; x++){
            line.add(array[y][x]);
        }
        
        for(x=x2, y=y1; y<y2; y++){
            line.add(array[y][x]);
        }
        
        for(x=x2, y=y2; x>x1; x--){
            line.add(array[y][x]);
        }
        
        for(x=x1, y=y2; y>y1; y--){
            line.add(array[y][x]);
        }
        
        // System.out.println();
        // for(int i=0; i<line.size(); i++){
        //     System.out.print(line.get(i) + " ");
        // }
        // System.out.println();
        return line;
    }
    
    public void lineToRotatedRect(int[][] array, ArrayList<Integer> line, int y1, int x1, int y2, int x2){
        int x;
        int y;
        int lineIndex = 0;
        
        for(x=x1, y=y1; x<x2; x++){
            if(x == x1){
                continue;
            }
            array[y][x] = line.get(lineIndex++);
        }
        
        for(x=x2, y=y1; y<y2; y++){
            array[y][x] = line.get(lineIndex++);
        }
        
        for(x=x2, y=y2; x>x1; x--){
            array[y][x] = line.get(lineIndex++);
        }
        
        for(x=x1, y=y2; y>y1; y--){
            array[y][x] = line.get(lineIndex++);
        }
        
        array[y][x] = line.get(lineIndex++);
    }
    
    public int getMinFromLine(ArrayList<Integer> line){
        int min = 987654321;
        for(int i=0; i<line.size(); i++){
            min = Math.min(min, line.get(i));
        }
        return min;
    }
    
    public int[][] createArray(int rows, int columns){
        int[][] array = new int[rows][columns];
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                array[i][j] = i*columns + j + 1;
            }
        }
        
        // System.out.printf("\n");
        // for(int i=0; i<array.length; i++){
        //     for(int j=0; j<array[0].length; j++){
        //         System.out.printf("%2d ", array[i][j]);
        //     }
        //     System.out.printf("\n");
        // }
        return array;
    }
}