//https://programmers.co.kr/learn/courses/30/lessons/87694

import java.util.*;

class Solution {
    public void drawRect(int[] rect, int[][] board, int[][] visited){
        //배열 인덱스를 고려해 y축 뒤집기 -> [좌측 상단 x, 좌측 상단 y, 우측 하단 x, 우측 하단 y]
        int startX = rect[0] * 2;
        int startY = rect[1] * 2;
        
        int width = (rect[2] - rect[0]) * 2;
        int height = (rect[3] - rect[1]) * 2;
        
        for(int i=0; i<=width; i++){
            //윗변
            if(board[startY][startX+i] != INSIDE)
                board[startY][startX+i]++;
            //아랫변
            if(board[startY+height][startX+i] != INSIDE)
                board[startY+height][startX+i]++;
        }
        
        //꼭지점 중복 방지
        for(int i=0; i<=height; i++){
            //왼쪽변
            if(board[startY+i][startX] != INSIDE)
                board[startY+i][startX]++;
            //오른쪽변
            if(board[startY+i][startX+width] != INSIDE)
                board[startY+i][startX+width]++;
        }
        
        //내부 제거
        for(int i=1; i<height; i++){
            for(int j=1; j<width; j++){
                board[startY+i][startX+j] = INSIDE;
            }
        }
    }
    
    public void printBoard(int[][] board){
        for(int i=MAX_BORDER-1; i>=0; i--){
            for(int j=0; j<MAX_BORDER; j++){
                if(board[i][j] == INSIDE)
                    System.out.printf("%2d ", 4);
                else if(board[i][j] == OUTSIDE)
                    System.out.printf("%2d ", 0);
                else
                    System.out.printf("%2d ", board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    class Point{
        int row;
        int column;
        public Point(int row, int column){
            this.row = row;
            this.column = column;
        }
    }
    
    final int INSIDE = -1;
    final int OUTSIDE = 0;
    final int MAX_BORDER = 51*2;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        // if(rectangle.length != 2) return -1;
        
        int[][] board = new int[MAX_BORDER][MAX_BORDER];
        int[][] visited = new int[MAX_BORDER][MAX_BORDER];
        
        for(var rect : rectangle){
            drawRect(rect, board, visited);
        }
        
        // printBoard(board);
        
        var queue = new LinkedList<Point>();
        queue.add(new Point(characterY*2, characterX*2));
        visited[characterY*2][characterX*2] = 1;
        
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        while(!queue.isEmpty()){
            var p = queue.poll();
            
            int nextRow;
            int nextColumn;
            
            for(int i=0; i<4; i++){
                nextRow = p.row + dr[i];
                nextColumn = p.column + dc[i];
                
                //배열 범위 체크
                if(nextRow < 0) continue;
                if(nextColumn < 0) continue;
                if(nextRow >= MAX_BORDER) continue;
                if(nextColumn >= MAX_BORDER) continue;
                
                //사각형 안쪽, 바깥쪽 체크
                if(board[nextRow][nextColumn] == INSIDE) continue;
                if(board[nextRow][nextColumn] == OUTSIDE) continue;
                
                //방문 체크
                if(visited[nextRow][nextColumn] != 0) continue;
                
                //기존 탐색이 더 짧은 거리라면 중단
                if(visited[nextRow][nextColumn] != 0 && 
                   visited[nextRow][nextColumn] <= visited[p.row][p.column]+1) continue;
                
                //붙어있는 것들 처리할 때 모순이 발생.........
                
                //방문 처리
                visited[nextRow][nextColumn] = visited[p.row][p.column]+1;
                
                //도착점 체크
                if(nextRow == itemY*2 && nextColumn == itemX*2) continue;
                
                // System.out.print("(" + nextRow + "," + nextColumn + ") ");
                queue.add(new Point(nextRow, nextColumn));
            }
        }
        
        // printBoard(visited);
        
        return (visited[itemY*2][itemX*2]-1)/2;
    }
}



// import java.util.*;

// class Solution {
//     public void drawRect(int[] rect, int[][] board, int[][] visited){
//         //배열 인덱스를 고려해 y축 뒤집기 -> [좌측 상단 x, 좌측 상단 y, 우측 하단 x, 우측 하단 y]
//         int startX = rect[0];
//         int startY = rect[1];
//         int endX = rect[2];
//         int endY = rect[3];
        
//         int width = endX - startX;
//         int height = endY - startY;
        
//         for(int i=0; i<=width; i++){
//             //윗변
//             if(board[startY][startX+i] != INSIDE)
//                 board[startY][startX+i]++;
//             //아랫변
//             if(board[startY+height][startX+i] != INSIDE)
//                 board[startY+height][startX+i]++;
//         }
        
//         //꼭지점 중복 방지
//         for(int i=1; i<height; i++){
//             //왼쪽변
//             if(board[startY+i][startX] != INSIDE)
//                 board[startY+i][startX]++;
//             //오른쪽변
//             if(board[startY+i][startX+width] != INSIDE)
//                 board[startY+i][startX+width]++;
//         }
        
//         //내부 제거
//         for(int i=1; i<height; i++){
//             for(int j=1; j<width; j++){
//                 board[startY+i][startX+j] = INSIDE;
//             }
//         }
//     }
    
//     public void printBoard(int[][] board){
//         for(int i=MAX_BORDER-1; i>=0; i--){
//             for(int j=0; j<MAX_BORDER; j++){
//                 if(board[i][j] == INSIDE)
//                     System.out.print(5);
//                 else if(board[i][j] == OUTSIDE)
//                     System.out.print(0);
//                 else
//                     System.out.print(board[i][j]);
//             }
//             System.out.println();
//         }
//         System.out.println();
//     }
    
//     class Point{
//         int row;
//         int column;
//         public Point(int row, int column){
//             this.row = row;
//             this.column = column;
//         }
//     }
    
//     final int INSIDE = -1;
//     final int OUTSIDE = 0;
//     final int MAX_BORDER = 51;
//     public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
//         int answer = 0;
        
//         int[][] board = new int[MAX_BORDER][MAX_BORDER];
//         int[][] visited = new int[MAX_BORDER][MAX_BORDER];
        
//         for(var rect : rectangle){
//             drawRect(rect, board, visited);
//         }
        
//         // printBoard(board);
        
//         var queue = new LinkedList<Point>();
//         queue.add(new Point(characterY, characterX));
//         visited[characterY][characterX] = 1;
        
//         int[] dr = {-1, 0, 1, 0};
//         int[] dc = {0, -1, 0, 1};
//         while(!queue.isEmpty()){
//             var p = queue.poll();
            
//             int nextRow;
//             int nextColumn;
            
//             for(int i=0; i<4; i++){
//                 nextRow = p.row + dr[i];
//                 nextColumn = p.column + dc[i];
                
//                 //배열 범위 체크
//                 if(nextRow < 0) continue;
//                 if(nextColumn < 0) continue;
//                 if(nextRow >= MAX_BORDER) continue;
//                 if(nextColumn >= MAX_BORDER) continue;
                
//                 //사각형 안쪽, 바깥쪽 체크
//                 if(board[nextRow][nextColumn] == INSIDE) continue;
//                 if(board[nextRow][nextColumn] == OUTSIDE) continue;
                
//                 //방문 체크
//                 if(visited[nextRow][nextColumn] != 0) continue;
                
//                 //기존 탐색이 더 짧은 거리라면 중단
//                 if(visited[nextRow][nextColumn] != 0 && 
//                    visited[nextRow][nextColumn] <= visited[p.row][p.column]+1) continue;
                
//                 //붙어있는 것들 처리할 때 모순이 발생.........
                
//                 //방문 처리
//                 visited[nextRow][nextColumn] = visited[p.row][p.column]+1;
                
//                 //도착점 체크
//                 if(nextRow == itemY && nextColumn == itemX) continue;
                
//                 // System.out.print("(" + nextRow + "," + nextColumn + ") ");
//                 queue.add(new Point(nextRow, nextColumn));
//             }
//         }
        
//         // printBoard(visited);
        
//         return visited[itemY][itemX]-1;
//     }
// }