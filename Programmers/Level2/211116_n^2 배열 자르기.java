//https://programmers.co.kr/learn/courses/30/lessons/87390

class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int)(right-left) + 1;
        int[] arr = new int[len];
        int index = 0;
        
        while(index < len){
            long from = left + (long)index;
            long fromRow = from / (long)n;
            long fromColumn = from % (long)n;
        
            arr[index++] = (int)Math.max(fromRow, fromColumn) + 1;//answer[fromRow][fromColumn];
        }
        
        return arr;
    }
}