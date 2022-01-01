//https://programmers.co.kr/learn/courses/30/lessons/84021#

import java.util.*;

class Solution {
    public enum TableType { GAME_BOARD, PUZZLE };
    
    public int solution(int[][] game_board, int[][] table) {
        //모든 퍼즐 조각 얻기
        ArrayList<int[][]> puzzlePieces = new ArrayList();
        int[][] puzzleVisited = new int[table.length][table[0].length];
        for(int i=0; i<table.length; i++){
            for(int j=0; j<table[0].length; j++){
                if(table[i][j] == 1 && puzzleVisited[i][j] == 0){
                    puzzlePieces.add(getTableFragment(i, j, table, puzzleVisited, TableType.PUZZLE));
                }
            }
        }
        // printTable(table);
        // printTable(puzzleVisited);
        // System.out.println("-------------------");
        
        //게임판의 모든 빈 공간 얻기
        ArrayList<int[][]> gameBoardPieces = new ArrayList();
        int[][] gameBoardVisited = new int[game_board.length][game_board[0].length];
        for(int i=0; i<game_board.length; i++){
            for(int j=0; j<game_board[0].length; j++){
                if(game_board[i][j] == 0 && gameBoardVisited[i][j] == 0){
                    gameBoardPieces.add(getTableFragment(i, j, game_board, gameBoardVisited, TableType.GAME_BOARD));
                }
            }
        }
        // printTable(game_board);
        // printTable(gameBoardVisited);
        // System.out.println("-------------------");
        
        int[] gameBoardElementCount = new int[gameBoardPieces.size()];
        for(int boardIndex=0; boardIndex<gameBoardPieces.size(); boardIndex++){
            gameBoardElementCount[boardIndex] = getElementCount(gameBoardPieces.get(boardIndex));
        }
        
        int answer = 0;
        boolean[] visited = new boolean[gameBoardPieces.size()];
        boolean[] visited22222 = new boolean[puzzlePieces.size()];
        int index22222=0;
        for(var puzzlePiece : puzzlePieces){
            int puzzleElementCount = getElementCount(puzzlePiece);
            int rotateCount = 4;
            do{
                for(int boardIndex=0; boardIndex<gameBoardPieces.size(); boardIndex++){
                    //이미 퍼즐을 맞춘 부분 탐색 제외
                    if(visited[boardIndex]) continue;
                    
                    //요소 갯수가 다르면 탐색 제외
                    if(puzzleElementCount != gameBoardElementCount[boardIndex]) continue;
                    
                    //게임판의 빈 공간과 퍼즐을 비교
                    var gameBoardPiece = gameBoardPieces.get(boardIndex);
                    
                    //퍼즐이 맞춰지는 부분 발견
                    if(compareTable(puzzlePiece, gameBoardPiece, puzzleElementCount)){
                        // System.out.println("퍼즐이 맞춰지는 부분 발견");
                        visited[boardIndex] = true;
                        visited22222[index22222] = true;
                        answer += puzzleElementCount;
                        // printTable(gameBoardPiece);
                        rotateCount = 0;
                        break;
                    }
                }
                puzzlePiece = rotateSquare90(puzzlePiece);
                
            } while(--rotateCount > 0);
            index22222++;
        }
        
        // for(int i=0; i<visited.length; i++){
        //     if(!visited[i])
        //     {
        //         System.out.println("못맞춘거 겜판");
        //         printTable(gameBoardPieces.get(i));
        //     }
        // }
        // for(int i=0; i<visited22222.length; i++){
        //     if(!visited22222[i])
        //     {
        //         System.out.println("못맞춘거 퍼즐");
        //         printTable(puzzlePieces.get(i));
        //     }
        // }
        return answer;
    }
    
    public int[][] getTableFragment(int startRow, int startColumn, int[][] table, int[][] visited, TableType tableType){
        //게임판에선 0으로 된 부분을 분리하고, 퍼즐 테이블에선 1로 된 부분을 분리한다.
        final int EXIST = (tableType == TableType.GAME_BOARD) ? 0 : 1;
        final int EMPTY = (tableType == TableType.GAME_BOARD) ? 1 : 0;
        final int NOT_VISITED = 0;
        
        //분리될 퍼즐 조각 범위
        Point minPoint = new Point(startRow, startColumn);
        Point maxPoint = new Point(startRow, startColumn);
        
        //BFS 탐색 준비
        int[] dr = {-1,0,1,0};
        int[] dc = {0,-1,0,1};
        
        var queue = new LinkedList<Point>();
        queue.add(new Point(startRow, startColumn));
        
        int[][] visited2 = new int[table.length][table[0].length];
        visited[startRow][startColumn] = 1;
        visited2[startRow][startColumn] = 1;
        
        //BFS 탐색
        while(!queue.isEmpty()){
            var current = queue.poll();
            for(int i=0; i<4; i++){
                int nextR = current.row + dr[i];
                int nextC = current.column + dc[i];
                
                if(nextR < 0) continue;
                if(nextC < 0) continue;
                if(nextR >= table.length) continue;
                if(nextC >= table[0].length) continue;
                
                if(visited[nextR][nextC] != NOT_VISITED) continue;
                if(table[nextR][nextC] != EXIST) continue;
                
                visited[nextR][nextC] = visited[current.row][current.column] + 1;
                visited2[nextR][nextC] = visited2[current.row][current.column] + 1;
                queue.add(new Point(nextR, nextC));
                
                //분리될 퍼즐 조각 범위 기록
                minPoint.row = Math.min(minPoint.row, nextR);
                minPoint.column = Math.min(minPoint.column, nextC);
                maxPoint.row = Math.max(maxPoint.row, nextR);
                maxPoint.column = Math.max(maxPoint.column, nextC);
            }
        }
        
        //퍼즐 조각 분리
        int height = maxPoint.row - minPoint.row;
        int width = maxPoint.column - minPoint.column;
        int squareSize = Math.max(height, width) + 1;
        int[][] tableFragment = new int[squareSize][squareSize];
        
        for(int i=0; i<squareSize; i++){
            for(int j=0; j<squareSize; j++){
                if(minPoint.row + i >= table.length) continue;
                if(minPoint.column + j >= table[0].length) continue;
                if(visited2[minPoint.row + i][minPoint.column + j] == 0) continue;
                
                tableFragment[i][j] = 1;
            }
        }
        // printTable(tableFragment);
        return tableFragment;
    }
    
    public int getElementCount(int[][] table){
        int count = 0;
        for(int i=0; i<table.length; i++){
            for(int j=0; j<table[0].length; j++){
                if(table[i][j] == 1)
                    count++;
            }
        }
        return count;
    }
    
    public boolean compareTable(int[][] table1, int[][] table2, int elementCount){
        int size1 = table1.length;
        int size2 = table2.length;
        
        for(int i=0-size1; i<size1+size2; i++){
            for(int j=0-size1; j<size1+size2; j++){
                int count = elementCount;
                
                for(int k=0; k<size2; k++){
                    for(int l=0; l<size2; l++){
                        if(i+k<0) continue;
                        if(j+l<0) continue;
                        if(i+k>=size1) continue;
                        if(j+l>=size1) continue;
                        
                        if(table2[k][l] == 1 && table1[i+k][j+l] == 1) 
                            count--;
                    }
                }
                
                if(count == 0) return true;
            }
        }
        
        return false;
    }
    
    public class Point{
        int row;
        int column;
        
        public Point(int row, int column){
            this.row = row;
            this.column = column;
        }
        
        @Override
        public String toString(){
            return "(" + row + "," + column + ")";
        }
    }
    
    public int[][] rotateSquare90(int[][] square){
        int[][] rotatedSquare = new int[square.length][square[0].length];
        
        for(int j=0; j<square[0].length; j++){
            for(int i=square.length-1; i>=0; i--){
                rotatedSquare[j][Math.abs(square.length-i-1)] = square[i][j];
            }
        }
        
        return rotatedSquare;
    }
    
    public void printTable(int[][] table){
        for(int i=0; i<table.length; i++){
            for(int j=0; j<table[0].length; j++){
                System.out.printf("%2d ", table[i][j]);
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
    }
}