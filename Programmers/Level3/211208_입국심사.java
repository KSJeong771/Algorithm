//https://programmers.co.kr/learn/courses/30/lessons/43238#

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        double pos = 0;
        for(int i=0; i<times.length; i++){
            pos += 1D / times[i];
        }
        
        //가장 그럴싸한 위치를 고른다.
        pos = n/pos;
        
        var timeHeap = new PriorityQueue<Time>();
        for(int i=0; i<times.length; i++){
            //가장 그럴싸한 위치에 몇 명이나 처리되었는지 계산
            long processed = (long)(pos / times[i]);
            n -= processed;
            timeHeap.offer(new Time(processed * times[i], times[i]));
            //System.out.println("위치 : " + pos + ", 처리 갯수 : " + processed);
        }
        
        long max = (long) pos;
        while(!timeHeap.isEmpty() && n-- > 0){
            var time = timeHeap.poll();
            time.accumulated += time.base;
            timeHeap.offer(time);
            max = time.accumulated;
        }
        
        return max;
    }
        
    class Time implements Comparable<Time>{
        long accumulated;
        long base;
        
        public Time(long accumulated, long base){
            this.accumulated = accumulated;
            this.base = base;
        }
        
        @Override
        public int compareTo(Time ti){
            return Long.compare(this.accumulated + this.base,
                                  ti.accumulated + ti.base);
        }
        
        @Override
        public String toString(){
            return "(" + accumulated + "," + base + ")";
        }
    }
}