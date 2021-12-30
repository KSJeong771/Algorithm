//https://programmers.co.kr/learn/courses/30/lessons/60059#

class Solution {
    public int[][] rotateMatrix90(int[][] matrix){
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] rotatedMatrix = new int[height][width];
        
        //90도 회전시키려면 원본 배열을 아래에서 위로, 왼쪽에서 오른쪽으로 읽어주면 된다.
        for(int j=0; j<width; j++){
            for(int i=height-1; i>=0; i--){
                rotatedMatrix[j][Math.abs(height-1-i)] = matrix[i][j];
            }
        }
        
        return rotatedMatrix;
    }
    
    public boolean canOpen(int row, int column, int[][] key, int[][] lock, int holeCount){
        for(int i=0; i<key.length; i++){
            for(int j=0; j<key[0].length; j++){
                int y = i+row;
                int x = j+column;
                
                if(y < 0) continue;
                if(x < 0) continue;
                if(y >= lock.length) continue;
                if(x >= lock[0].length) continue;
                
                if(lock[y][x] == 1 && key[i][j] == 1)
                    return false;
                
                if(lock[y][x] == 0 && key[i][j] == 1)
                    holeCount--;
            }
        }
        
        return (holeCount == 0);
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        int[][][] rotatedKey = new int[4][][];
        rotatedKey[0] = key;
        rotatedKey[1] = rotateMatrix90(rotatedKey[0]);
        rotatedKey[2] = rotateMatrix90(rotatedKey[1]);
        rotatedKey[3] = rotateMatrix90(rotatedKey[2]);
        
        int holeCount = 0;
        for(int i=0; i<lock.length; i++){
            for(int j=0; j<lock[0].length; j++){
                if(lock[i][j] == 0)
                    holeCount++;
            }
        }
        
        //자물쇠 완전탐색
        int keyWidth = key.length;
        int keyHeight = key[0].length;
        for(int i=1-keyHeight; i<lock.length + keyHeight-1; i++){
            for(int j=1-keyWidth; j<lock[0].length + keyWidth-1; j++){
                //4방향 체크
                for(int k=0; k<rotatedKey.length; k++){
                    if(canOpen(i, j, rotatedKey[k], lock, holeCount))
                        return true;
                }
            }
        }
        
        return false;
    }
}