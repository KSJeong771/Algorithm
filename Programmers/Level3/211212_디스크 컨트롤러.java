//https://programmers.co.kr/learn/courses/30/lessons/42627#

import java.util.*;

class Solution {
    class Schedule {
        int startTime;
        int duration;
        int currentTime;
        
        public Schedule(int startTime, int duration){
            this.startTime = startTime;
            this.duration = duration;
            this.currentTime = 0;
        }
        
        @Override
        public String toString(){
            String temp = "(";
            temp += this.startTime;
            temp += ",";
            temp += this.duration;
            temp += ")";
            return temp;
        }
    }
    public int solution(int[][] jobs) {
        var list = new ArrayList<Schedule>();
        for(var job : jobs){
            list.add(new Schedule(job[0], job[1]));
        }        
        
            // for(var v : list)
            //     System.out.print(v + " ");
            //     System.out.print("\n");
        
        //실제 흐른 시간
        int currentTime = 0;
        
        //요청부터 종료까지 소요된 시간의 합
        int result = 0;
        
        while(!list.isEmpty()){
            //시작시간 변경
            for(var v : list)
                v.currentTime = currentTime;
            
            //정렬
            Collections.sort(list, new Comparator<Schedule>(){
                public int compare(Schedule a, Schedule b){
                    if((a.startTime == b.startTime) 
                       || (a.startTime - a.currentTime <= 0 && b.startTime - b.currentTime <= 0)){
                        if(a.duration == b.duration)
                            return a.startTime - b.startTime;
                        else
                            return a.duration - b.duration;
                    }
                    else{
                        return a.startTime - b.startTime;
                    }
                }
            });
            
            // System.out.print("currentTime : " + currentTime + " ");
            //최소값 뽑기
            var minNode = list.get(0);
            list.remove(0);
            // System.out.print("minNode : " + minNode + " ");
            
            //시간 업데이트
            if(minNode.startTime > currentTime)
                currentTime += (minNode.startTime - currentTime);
            
            //현재 시간 이전에 미리 할당된 노드이면
            if(currentTime > minNode.startTime){
                //이미 할당되어 대기하고 있었던 시간을 계산
                int gap = currentTime - minNode.startTime;
                result += gap;
            // System.out.print("gap : " + gap + " ");
            }
            
            result += minNode.duration;
            currentTime += minNode.duration;
            
//             System.out.print("newTime : " + currentTime + " ");
            
//             System.out.print("remaining : ");
//             for(var v : list)
//                 System.out.print(v + " ");
//                 System.out.print("\n");
        }
        
        return result/jobs.length;
    }
}