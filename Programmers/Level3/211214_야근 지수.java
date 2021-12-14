//https://programmers.co.kr/learn/courses/30/lessons/12927

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        //힙에 모든 원소를 넣고 n=0 될때까지 깎아내기
        //힙 크기 : 1,000,000 * 4Byte
        //빼서-O(1) 깎고-O(1) 넣고-O(logN) 를 n번 반복
        //평균 등 값을 이용해서 시간 감소시킬 여지 있음
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        for(var work : works){
            maxHeap.add(work);
        }
        
        while(n > 0){
            var work = maxHeap.poll() - 1;
            if(work < 0) work = 0;
            maxHeap.add(work);
            n--;
        }
        
        long fartigue = 0;
        while(!maxHeap.isEmpty()){
            var work = maxHeap.poll();
            fartigue += (work * work);
        }
        
        return fartigue;
    }
}