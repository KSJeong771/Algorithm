//https://programmers.co.kr/learn/courses/30/lessons/12907#

class Solution {
    public int solution(int n, int[] money) {
        int[] rowSum = new int[n+1];
        
        //동전 1개만을 사용하여 거슬러 주는 경우
        //나누어 떨어지면 경우의 수가 1, 나누어 떨어지면 0이다.
        for(int row=0; row<=n; row++){
            rowSum[row] = (row % money[0]) == 0 ? 1 : 0;
        }
        
        //동전 2개 이상을 사용할 경우 이전에 계산한 경우의 수를 활용할 수 있다.
        //예시) 4원을 거슬러 주는 경우 {1111, 112, 22}
        //     여기서 2가 사용된 경우만 뽑으면 {112, 22}이고
        //     이는 2원을 거슬러 준 경우인 {11, 2}에 숫자만 붙여준 것과 같다.
        for(int column=1; column<money.length; column++){
            for(int row=money[column]; row<=n; row++){
                rowSum[row] += rowSum[row - money[column]];
            }
        }
        
        return rowSum[n] % 1000000007;
    }
}

//시간초과
// class Solution {
//     public int solution(int n, int[] money) {
//         int answer = 0;
        
//         int[][] table = new int[n+1][money.length];
        
//         //동전 1개만을 사용하여 거슬러 주는 경우
//         //나누어 떨어지면 경우의 수가 1, 나누어 떨어지면 0이다.
//         for(int row=0; row<=n; row++)
//             table[row][0] = (row % money[0]) == 0 ? 1 : 0;
        
//         //동전 2개 이상을 사용할 경우 이전에 계산한 경우의 수를 활용할 수 있다.
//         //예시) 4원을 거슬러 주는 경우 {1111, 112, 22}
//         //여기서 2가 사용된 경우만 뽑으면 {112, 22}이고
//         //이는 2원을 거슬러 준 경우인 {11, 2}에 숫자만 붙여준 것과 같다.
//         for(int column=1; column<money.length; column++){
//             int currentMoney = money[column];
            
//             for(int row=1; row<=n; row++){
//                 if(row-currentMoney < 0){
//                     System.out.println("row-currentMoney < 0 .. " + (row-currentMoney));
//                     continue;
//                 }
                
//                 for(int i=0; i<=column; i++){
//                     table[row][column] += table[row - currentMoney][i];
//                 }
//             }
//         }
        
//         System.out.println("-----------------------------");
//         for(int j=0; j<=n; j++){
//             System.out.print("row " + j + " : ");
//             for(int i=0; i<money.length; i++){
//                 System.out.print(table[j][i] + " ");
//             }
//             System.out.println();
//         }
//         System.out.println();
        
        
//         for(var v : table[n])
//             answer += v;
        
//         return answer % 1000000007;
//     }
// }