//https://school.programmers.co.kr/learn/courses/30/lessons/92342

class Solution {
    public int[] solution(int n, int[] info) {
        int[] apeach = new int[11];
        
        dfs(info, apeach.clone(), 0, n);
        
        int lionSum = 0;
        for (int i=0; i<10; i++) {
            if (info[i] > 0) {
                lionSum += (10-i);
            }
        }
        
        if (lionSum >= maxSum) {
            return new int[] {-1};
        }
        
        return maxArray;
    }
    
    int[] maxArray;
    int maxSum = -1;
    
    int addSum(int[] array, int[] info) {
        int result = 0;
        for (int i=0; i<11; i++) {
            if (info[i] < array[i]) {
                result += (10-i);
                if (info[i] > 0) {
                    result += (10-i);
                }
            }
        }
        return result;
    }
    
    void dfs(int[] lion, int[] apeach, int depth, int n) {
        if (depth == 11) {
            if (n > 0) {
                apeach[10] += n;
            }
            int sum = addSum(apeach, lion);
            if (sum > maxSum) {
                maxArray = apeach;
                maxSum = sum;
            } else if (sum == maxSum) {
                for (int i=10; i>=0; i--) {
                    if (apeach[i] > maxArray[i]) {
                        maxArray = apeach;
                        maxSum = sum;
                        break;
                    } else if (apeach[i] < maxArray[i]) {
                        break;
                    }
                }
            }
            return;
        }
        
        if (n >= lion[depth]+1) {
            int[] newApeach = apeach.clone();
            newApeach[depth] = lion[depth] + 1;
            dfs(lion, newApeach, depth + 1, n - (lion[depth] + 1));
        }
        
        dfs(lion, apeach.clone(), depth+1, n);
    }
}