//https://school.programmers.co.kr/learn/courses/30/lessons/131130

class Solution {
    
    int maxValue(int[] array) {
        int max = 0;
        for (int i=0; i<array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }
    
    void dfs(int[] cards, int[] points, int[] visited, int depth) {
        if (depth > 1) {
            return;
        }
        
        for (int i=0; i<cards.length; i++) {
            int numberInBox = i;
            
            while (true) {
                points[i]++;
                visited[numberInBox]++;
                numberInBox = cards[numberInBox]-1;
                if (cards[numberInBox] - 1 == numberInBox) break;
                if (visited[numberInBox] > 0) break;
            }
            
            int[] nextLevelPoints = new int[cards.length];
            dfs(cards, nextLevelPoints, visited, depth + 1);
            points[i] *= maxValue(nextLevelPoints);
            System.out.println("points[i] : " + points[i] );
        }
    }
    
    public int solution(int[] cards) {
        int answer = 0;
        
        int[] points = new int[cards.length];
        for (int i=0; i<cards.length; i++) {
            int[] visited = new int[cards.length];
            int index = i;
            
            while (true) {
                visited[index]++;
                index = cards[index]-1;
                points[i]++;
                if (cards[index] - 1 == index) {
                    break;
                }
                if (visited[index] > 0) {
                    break;
                }
            }
            
            int[] points2 = new int[cards.length];
            for (int j=0; j<cards.length; j++) {
                index = j;
                if (visited[index] > 0) {
                    continue;
                }
                while (true) {
                    visited[index]++;
                    index = cards[index]-1;
                    points2[j]++;
                    if (cards[index] - 1 == index) {
                        break;
                    }
                    if (visited[index] > 0) {
                        break;
                    }
                }
            }
            int max = 0;
            for (int j=0; j<cards.length; j++) {
                if (max < points2[j]) {
                    max = points2[j];
                }
            }
            System.out.println("points[i] : " + points[i] + " max : " + max);
            points[i] *= max;
        }
        
        int max = -1;
        for (int j=0; j<cards.length; j++) {
            if (max < points[j]) {
                max = points[j];
            }
        }
        for (int i=0; i<cards.length; i++) {
            System.out.print(points[i] + " ");
        }
        
        return maxValue(points);
    }
}