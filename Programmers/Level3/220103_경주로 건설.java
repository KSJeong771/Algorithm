import java.util.*;

class Solution {
    public int solution(int[][] board) {
        //3차원 배열로 다시 풀기
        int height = board.length;
        int width = board[0].length;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        
        int[][][] visited = new int[height][width][4];
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                for(int k=0; k<4; k++){
                    visited[i][j][k] = 987654321;
                }
            }
        }
        
        var queue = new LinkedList<Point>();
        queue.add(new Point(0,0,0,2));
        queue.add(new Point(0,0,0,3));
        visited[0][0][2] = 0;
        visited[0][0][3] = 0;
        
        while(!queue.isEmpty()){
            var current = queue.poll();
            
            if(current.row == height-1 && current.column == width-1){
                continue;
            }
            
            int cost = visited[current.row][current.column][current.direction];
                
            for(int nextDir=0; nextDir<4; nextDir++){
                int nextR = current.row + dr[nextDir];
                int nextC = current.column + dc[nextDir];
                
                if(nextR < 0) continue;
                if(nextC < 0) continue;
                if(nextR >= height) continue;
                if(nextC >= width) continue;
                
                if(board[nextR][nextC] == 1) continue;
                
                int nextCost = (current.direction == nextDir) ? cost + 1 : cost + 6;
                if(visited[nextR][nextC][nextDir] > nextCost){
                    visited[nextR][nextC][nextDir] = nextCost;
                    queue.add(new Point(nextR, nextC, nextCost, nextDir));
                }
            }
        }
        for(int k=0; k<4; k++){
            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){                
                    if(visited[i][j][k] == 987654321)
                        System.out.printf("%3d ", -1);
                    else 
                        System.out.printf("%3d ", visited[i][j][k]);
                }
                    System.out.println();
            }
                    System.out.println();
        }
        
        int answer = 987654321;
        for(int i=0; i<4; i++)
            answer = Math.min(answer, visited[height-1][width-1][i]);
        
        return answer * 100;
    }
    
    public class Point{
        int row;
        int column;
        int cost;
        int direction;
        
        public Point(int row, int column, int cost, int direction){
            this.row = row;
            this.column = column;
            this.cost = cost;
            this.direction = direction;
        }
        
        @Override
        public String toString(){
            return "(" + row + "," + column + "," + cost + "," + direction + ")";
        }
    }
}


// import java.util.*;

// class Solution {
//     final int NOT_VISITED = 987654321;
//     final int WALL = 1;
    
//     public int solution(int[][] board) {
//         int answer = 0;
        
//         var queue = new LinkedList<Point>();
//         queue.add(new Point(0,0,0,2));
//         queue.add(new Point(0,0,0,3));
        
//         Point[][] visited = new Point[board.length][board[0].length];
//         for(int i=0; i<visited.length; i++){
//             for(int j=0; j<visited[0].length; j++){
//                 visited[i][j] = new Point(i,j,NOT_VISITED,-1);
//             }
//         }
//         visited[0][0].cost = 0;
        
//         int[] dr = {-1, 0, 1, 0};
//         int[] dc = {0, -1, 0, 1};
        
//         while(!queue.isEmpty()){
//             var current = queue.poll();

//             if(current.row == board.length-1 && current.column == board[0].length-1) {
//                 answer = Math.min(answer, visited[current.row][current.column].cost);
//                 continue;
//             }
            
//             for(int direction=0; direction<4; direction++){
//                 int nextR = current.row + dr[direction];
//                 int nextC = current.column + dc[direction];
//                 int nextCost = (direction == current.direction) ? current.cost + 1 : current.cost + 6;
//                 int nextDirection = direction;
// // if(nextR == 3 && nextC == 4){
// //     System.out.println("(3,4) currentDir : " + current.direction + " visitedCurrent : " + visited[current.row][current.column] + " nextDir : " + nextDirection + " visitedNext : " + visited[nextR][nextC]);
// // }
                
//                 if(nextR < 0) continue;
//                 if(nextC < 0) continue;
//                 if(nextR >= board.length) continue;
//                 if(nextC >= board[0].length) continue;
                
//                 if(board[nextR][nextC] == WALL) continue;
                
//                 Point nextPoint = new Point(nextR, nextC, nextCost, nextDirection);              
                
//                 if(visited[nextR][nextC].cost == NOT_VISITED || visited[nextR][nextC].cost > nextPoint.cost-4){
//                     visited[nextR][nextC] = nextPoint;
//                     queue.add(nextPoint);
//                 }
//             }
//         }
        
//         printVisited(visited);
        
//         return 100 * (visited[visited.length-1][visited[0].length-1].cost);
//     }
    
//     public class Point{
//         int row;
//         int column;
//         int cost;
//         int direction;
        
//         public Point(int row, int column, int cost, int direction){
//             this.row = row;
//             this.column = column;
//             this.cost = cost;
//             this.direction = direction;
//         }
        
//         @Override
//         public String toString(){
//             StringBuilder result = new StringBuilder();
            
//             switch(direction){
//                 case 0:
//                     result.append("↑");
//                     break;
//                 case 1:
//                     result.append("←");
//                     break;
//                 case 2:
//                     result.append("↓");
//                     break;
//                 case 3:
//                     result.append("→");
//                     break;
//                 default:
//                     result.append("X");
//                     break;
//             }
            
//             result.append(cost);
            
//             return result.toString();
//         }
//     }
    
//     public void printVisited(Point[][] visited){
//         for(int i=0; i<visited.length; i++){
//             for(int j=0; j<visited[0].length; j++){
//                 if(visited[i][j].cost == NOT_VISITED)
//                     System.out.printf("%3s ", "X0");
//                 else
//                     System.out.printf("%3s ", visited[i][j]);
//             }
//             System.out.printf("\n");
//         }
//         System.out.printf("\n");
//     }
// }


// import java.util.*;

// class Solution {
//     public int solution(int[][] board) {
//         int answer = 0;
        
//         var queue = new LinkedList<Point>();
//         queue.add(new Point(0,0,-5,-1));
        
//         Point[][] visited = new Point[board.length][board[0].length];
//         for(int i=0; i<visited.length; i++){
//             for(int j=0; j<visited[0].length; j++){
//                 visited[i][j] = new Point(i,j,0,-1);
//             }
//         }
//         visited[0][0] = new Point(0,0,-5,-1);
        
//         int[] dr = {-1, 0, 1, 0};
//         int[] dc = {0, -1, 0, 1};
        
//         final int NOT_VISITED = 0;
//         final int WALL = 1;
        
//         while(!queue.isEmpty()){
//             var current = queue.poll();
//             for(int direction=0; direction<4; direction++){
//                 int nextR = current.row + dr[direction];
//                 int nextC = current.column + dc[direction];
//                 int nextCost = (direction == current.direction) ? current.cost + 1 : current.cost + 6;
//                 int nextDirection = direction;
                
//                 if(nextR < 0) continue;
//                 if(nextC < 0) continue;
//                 if(nextR >= board.length) continue;
//                 if(nextC >= board[0].length) continue;
                
//                 if(board[nextR][nextC] == WALL) continue;
                
//                 Point nextPoint = new Point(nextR, nextC, nextCost, nextDirection);              
                
//                 if(visited[nextR][nextC].cost != NOT_VISITED && visited[nextR][nextC].cost < nextPoint.cost) continue;
//                 visited[nextR][nextC] = nextPoint;
                
//                 if(nextR == board.length-1 && nextC == board[0].length-1) continue;
//                 queue.add(nextPoint);
//             }
//         }
        
//         // printVisited(visited);
        
//         return 100 * (visited[visited.length-1][visited[0].length-1].cost);
//     }
    
//     public class Point{
//         int row;
//         int column;
//         int cost;
//         int direction;
        
//         public Point(int row, int column, int cost, int direction){
//             this.row = row;
//             this.column = column;
//             this.cost = cost;
//             this.direction = direction;
//         }
        
//         @Override
//         public String toString(){
//             StringBuilder result = new StringBuilder();
            
//             switch(direction){
//                 case 0:
//                     result.append("↑");
//                     break;
//                 case 1:
//                     result.append("←");
//                     break;
//                 case 2:
//                     result.append("↓");
//                     break;
//                 case 3:
//                     result.append("→");
//                     break;
//                 default:
//                     result.append("X");
//                     break;
//             }
            
//             result.append(cost);
            
//             return result.toString();
//         }
//     }
    
//     public void printBoard(int[][] board){
//         for(int i=0; i<board.length; i++){
//             for(int j=0; j<board[0].length; j++){
//                 System.out.printf("%2d ", board[i][j]);
//             }
//             System.out.printf("\n");
//         }
//         System.out.printf("\n");
//     }
    
//     public void printVisited(Point[][] visited){
//         for(int i=0; i<visited.length; i++){
//             for(int j=0; j<visited[0].length; j++){
//                 System.out.printf("%3s ", visited[i][j]);
//             }
//             System.out.printf("\n");
//         }
//         System.out.printf("\n");
//     }
// }