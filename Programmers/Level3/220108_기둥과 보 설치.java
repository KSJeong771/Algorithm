//https://programmers.co.kr/learn/courses/30/lessons/60061

import java.util.*;

class Solution {
    final int EMPTY = 0;
    final int EXIST = 1;
    
    public int[][] solution(int n, int[][] build_frame) {
        int[][][] structure = new int[2][n+1][n+1];
        
        for(var operation : build_frame){
        
            int x = operation[0];
            int y = operation[1];
            int frame = operation[2];
            
            int oldFrame = structure[frame][y][x];
            int newFrame = (operation[3] == 0) ? EMPTY : EXIST;
            
        // System.out.println("x:"+x + " y:" + y + " frame:" + frame + " operation:" + operation[3]);
        // printStructure(structure[0],n);
        // printStructure(structure[1],n);
            if(oldFrame == newFrame) continue;
            
            structure[frame][y][x] = newFrame;
            structure[frame][y][x] = canBuild(structure, n) ? newFrame : oldFrame;
        }
        
        ArrayList<int[]> result = new ArrayList();
        for(int j=0; j<=n; j++){
            for(int i=0; i<=n; i++){
                if(structure[0][i][j] == EXIST) result.add(new int[]{j,i,0});
                if(structure[1][i][j] == EXIST) result.add(new int[]{j,i,1});
            }
        }
        
        // printStructure(structure[0],n);
        // printStructure(structure[1],n);
        
        int[][] answer = new int[result.size()][];
        for(int i=0; i<result.size(); i++)
            answer[i] = result.get(i);
        
        return answer;

    }
    
    public void printStructure(int[][] structure, int n){
        for(int i=n; i>=0; i--){
            for(int j=0; j<n+1; j++){
                System.out.print(structure[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public boolean canBuildColumn(int y, int x, int[][][] structure, int n){
        //기둥은 바닥 위에 있거나
        if(y-1 < 0) return true;
        
        //보의 한쪽 끝 부분 위에 있거나
        if(structure[1][y][x] == EXIST || ((x-1 >= 0) && structure[1][y][x-1] == EXIST)) return true;
        
        //또는 다른 기둥 위에 있어야 합니다.
        if(structure[0][y-1][x] == EXIST) return true;
        
        return false;
    }
    
    public boolean canBuildFloor(int y, int x, int[][][] structure, int n){
        //보는 한쪽 끝 부분이 기둥 위에 있거나
        if(((y-1>=0) && structure[0][y-1][x] == EXIST) 
         || ((y-1>=0&&x+1<=n) && structure[0][y-1][x+1] == EXIST)) return true;
        
        //또는 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 합니다.
        if(((x-1>=0) && structure[1][y][x-1] == EXIST) 
        && ((x+1<=n) && structure[1][y][x+1] == EXIST)) return true;

        return false;
    }
    
    public boolean canBuild(int[][][] structure, int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(structure[0][i][j] == EXIST)
                    if(!canBuildColumn(i,j,structure, n)) return false;
                if(structure[1][i][j] == EXIST)
                    if(!canBuildFloor(i,j,structure, n)) return false;
            }     
        }        
        
        return true;
    }
}


// import java.util.*;

// class Solution {
//     final int GROUND = 64;
//     final int EMPTY = 0;
//     final int COLUMN = 1;
//     final int FLOOR = 2;
//     final int COLUMN_AND_FLOOR = 3;
    
//     public int[][] solution(int n, int[][] build_frame) {
//         int[][] structure = new int[n+1][n+1];
//         for(var operation : build_frame){
//             int x = operation[0];
//             int y = operation[1];
                
//             //구조가 규칙에 맞지 않을 경우를 대비해 이전 값 백업
//             int oldFrame = structure[y][x];
            
//             //이번 동작에 변경될 프레임 값 (기둥:1, 보:2, 둘 다:3)
//             int newFrame = structure[y][x];
            
//             //삭제일 경우 XOR
//             if(operation[3] == 0){
//                 newFrame ^= (operation[2] + 1);
//                 // System.out.println("삭제 oldFrame : " + oldFrame + " newFrame : " + newFrame);
//             }
//             //추가일 경우 OR
//             else{
//                 newFrame |= (operation[2] + 1);
//                 // System.out.println("추가 oldFrame : " + oldFrame + " newFrame : " + newFrame);
//             }
                        
//             //구조 변경 후 결함이 있다면 이전 구조로 롤백
//             structure[y][x] = newFrame;
//             structure[y][x] = findDefect(structure) ? oldFrame : newFrame;
//         }
        
//         ArrayList<int[]> result = new ArrayList();
//         for(int j=0; j<structure[0].length; j++){
//             for(int i=0; i<structure.length; i++){
//                 if(doesExistFrame(structure[i][j], COLUMN)) result.add(new int[]{j,i,COLUMN-1});
//                 if(doesExistFrame(structure[i][j], FLOOR))  result.add(new int[]{j,i,FLOOR-1});
//             }
//         }
//         //return 하는 배열은 x좌표 기준으로 오름차순 정렬하며, x좌표가 같을 경우 y좌표 기준으로 오름차순 정렬해주세요.
//         //x, y좌표가 모두 같은 경우 기둥이 보보다 앞에 오면 됩니다.
//         Collections.sort(result, new Comparator<int[]>(){
//             @Override
//             public int compare(int[] a, int[] b){
//                 if(a[0] == b[0]){
//                     if(a[1] == b[1]){
//                         return a[2]-b[2];
//                     }
//                     else{
//                         return a[1]-b[1];
//                     }
//                 }
//                 else{
//                     return a[0]-b[0];                    
//                 }
//             }
//         });
        
//         // for(int i=n; i>=0; i--){
//         //     for(int j=0; j<n+1; j++){
//         //         System.out.print(structure[i][j] + " ");
//         //     }
//         //     System.out.println();
//         // }
//         // System.out.println();
        
//         int[][] answer = new int[result.size()][];
//         for(int i=0; i<result.size(); i++)
//             answer[i] = result.get(i);
        
//         return answer;
        
//     }
    
//     public boolean doesExistFrame(int space, int frame){
//         return (space & frame) == frame;
//     }
    
//     public boolean findDefect(int[][] structure){
//         for(int i=0; i<structure.length; i++){
//             for(int j=0; j<structure[0].length; j++){
                
//                 int centerFrame = structure[i][j];
//                 int leftFrame = (j-1 < 0) ? EMPTY : structure[i][j-1];
//                 int rightFrame = (j+1 >= structure[0].length) ? EMPTY : structure[i][j+1];
//                 int downFrame = (i-1 < 0) ? GROUND : structure[i-1][j];
//                 int rightDownFrame = (i-1 < 0 || j+1 >= structure[0].length) ? GROUND : structure[i-1][j+1];
                
//                 //기둥은 바닥 위에 있거나 보의 한쪽 끝 부분 위에 있거나, 또는 다른 기둥 위에 있어야 합니다.
//                 if(doesExistFrame(centerFrame, COLUMN)){
//                     //바로 밑이 바닥
//                     if(doesExistFrame(downFrame, GROUND)) continue;
                    
//                     //바로 밑이 다른 기둥
//                     if(doesExistFrame(downFrame, COLUMN)) continue;
                    
//                     //현재 위치가 보
//                     if(doesExistFrame(centerFrame, FLOOR)) continue;
                    
//                     //왼쪽이 보
//                     if(doesExistFrame(leftFrame, FLOOR)) continue;
                    
//                     return true;
//                 }
                
//                 //보는 한쪽 끝 부분이 기둥 위에 있거나, 또는 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 합니다.
//                 if(doesExistFrame(centerFrame, FLOOR)){
//                     //바로 밑이 기둥
//                     if(doesExistFrame(downFrame, COLUMN)) continue;
                    
//                     //오른쪽 밑이 기둥
//                     if(doesExistFrame(rightDownFrame, COLUMN)) continue;
                    
//                     //양쪽 끝이 전부 보
//                     if(doesExistFrame(leftFrame, FLOOR) && doesExistFrame(rightFrame, FLOOR)) continue;
                        
//                     return true;
//                 }
//             }     
//         }        
        
//         return false;
//     }
// }