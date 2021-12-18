//https://programmers.co.kr/learn/courses/30/lessons/12979#

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = (w * 2) + 1;
        
        int left = 1;
        for(int i=0; i<stations.length; i++){
            int right = stations[i] - w - 1;
            int length = getLength(left, right);
            answer += getNumOfStation(length, range);
            left = stations[i] + w + 1;
        }
        
        if(left <= n){
            int lastLength = getLength(left, n);
            answer += getNumOfStation(lastLength, range);
        }
        
        return answer;
    }
    
    public int getLength(int left, int right){
        int length = right-left+1;
        if(length < 0){
            // System.out.println("length < 0");
            length = 0;
        }
        
        // System.out.println("left : " + left + " right : " + right + " length : " + length);
        return length;
    }
    
    public int getNumOfStation(int length, int range){
        int numOfStation = 0;
        if(length % range == 0){
            // System.out.println("length % range == 0");
            numOfStation = (length / range);
        }
        else{
            // System.out.println("length % range != 0");
            numOfStation = (length / range) + 1;
        }
        
        // System.out.println("length : " + length + " range : " + range + " numOfStation : " + numOfStation);
        return numOfStation;
    }
}

// import java.util.*;

// class Solution {
//     public int solution(int n, int[] stations, int w) {
//         int answer = 0;

//         ArrayList<Integer> outOfRangeLength = new ArrayList();
        
//         int stationRight = 0;
//         for(int i=0; i<stations.length; i++){
//             int stationCenter = stations[i]-1;
//             int stationLeft = (stationCenter-w < 0) ? 0 : stationCenter-w;
//             outOfRangeLength.add(stationLeft - stationRight);
            
//             // System.out.println("length : " + (stationLeft - stationRight) + " stationRight : " + stationRight);
//             stationRight = stationCenter+w+1;
//         }
//         //System.out.println("stationRight : " + stationRight);
        
//         if(stationRight < n){
//             outOfRangeLength.add(n - stationRight);
//         }
        
//         int range = w*2 + 1;
//         for(var length : outOfRangeLength){
//             // System.out.println("length : " + length);
            
//             answer += (length / range);
//             answer += (length % range == 0) ? 0 : 1;
//         }
            
        
//         return answer;
//     }
// }