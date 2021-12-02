//https://programmers.co.kr/learn/courses/30/lessons/17676?language=java

class Solution {
    public int solution(String[] lines) {
        int max = -1;
        int[][] time = new int[lines.length][2];
        final int SECOND = 999;
        
        int index = 0;
        for(var v: lines){
            time[index][1] = timeToMilisecond(v.split(" ")[1]);
            time[index][0] = time[index][1] - durationToMilisecond(v.split(" ")[2]) + 1;
            System.out.println(time[index][0] + " ~ " + time[index][1]);
            index++;
        }
        
        //타임라인끼리 비교하여 1초 이내에 들어오는 것이 있는지 체크
        for(int i=0; i<time.length; i++){
            int count = 0;
            for(int j=i; j<time.length; j++){
                if(time[j][0] <= time[i][1] + SECOND)
                    max = Math.max(max, ++count);
            }
        }
        
        return max;
    }
    
    public int timeToMilisecond(String time){
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        int second = Integer.parseInt(time.split(":")[2].split("\\.")[0]);
        int milisecond = Integer.parseInt(time.split(":")[2].split("\\.")[1]);
        
        return milisecond + second*1000 + minute*1000*60 + hour*1000*60*60;
    }
    
    public int durationToMilisecond(String duration){
        duration = duration.substring(0, duration.length()-1);
        int second = Integer.parseInt(duration.split("\\.")[0]);
        int milisecond = (duration.split("\\.").length== 1) ? 0 : Integer.parseInt(duration.split("\\.")[1]);
        
        return milisecond + second*1000;
    }
}