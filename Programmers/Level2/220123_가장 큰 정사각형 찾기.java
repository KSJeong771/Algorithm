//https://programmers.co.kr/learn/courses/30/lessons/12905#

class Solution
{
    public int solution(int [][]board)
    {
        int height = board.length;
        int width = board[0].length;
        int max = 0;
        
        for(int i=1; i<height; i++){
            for(int j=1; j<width; j++){
                if(board[i][j] == 0) continue;
                if(board[i-1][j-1] == 0) continue;
                if(board[i-1][j] == 0) continue;
                if(board[i][j-1] == 0) continue;
                
                int temp = board[i-1][j-1];
                temp = Math.min(temp, board[i][j-1]);
                temp = Math.min(temp, board[i-1][j]);
                board[i][j] = temp + 1;
                
                max = Math.max(max, board[i][j]);
            }
        }
        
        for(int i=0; i<height; i++)
            max = Math.max(max, board[i][0]);
            
        for(int j=0; j<width; j++)
            max = Math.max(max, board[0][j]);
        
//         for(int i=0; i<height; i++){
//             for(int j=0; j<width; j++){
//                 System.out.print(board[i][j] + " ");
//             }
//                 System.out.println();
//         }

        return max*max;
    }
}