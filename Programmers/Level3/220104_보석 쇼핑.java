//https://programmers.co.kr/learn/courses/30/lessons/67258

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        //모든 원소 종류와 좌표 파악
        HashMap<String, ArrayList<Integer>> map = new HashMap();
        for(int i=0; i<gems.length; i++){
            ArrayList<Integer> indexList = (map.get(gems[i]) == null) ? new ArrayList() : map.get(gems[i]);
            indexList.add(i);
            map.put(gems[i], indexList);
        }
        
        int[] answer = {-1,-1};
        
        //모든 원소를 찾았는지는 set의 크기를 이용해서 체크
        HashSet<String> set = new HashSet();
        int startIndex = 0;
        int lastIndex = 0;
        int minLength = 987654321;
        
        do{
            //변화된 범위 안에 이전 인덱스의 원소가 있는지 체크
            var indexList = (startIndex == 0) ? new ArrayList<Integer>() : map.get(gems[startIndex-1]);
            boolean exists = false;
            for(var index : indexList){
                if(startIndex <= index && index < lastIndex) {
                    exists = true;
                    break;
                }
            }
            
            if(!exists) {
                //set에서 이전 인덱스의 원소를 지우고
                if(startIndex != 0) set.remove(gems[startIndex-1]);
                
                //모든 원소 찾기
                lastIndex = startIndex;
                while(lastIndex < gems.length && set.size() < map.size()){
                    set.add(gems[lastIndex++]);
                }
            }
            
            //정답 최신화
            if(lastIndex-startIndex < minLength && set.size() == map.size()){
                answer[0] = startIndex+1;
                answer[1] = lastIndex;
                minLength = lastIndex-startIndex;
            }
            
            //다음 원소로 넘어가기
            startIndex++;
        }
        while(set.size() == map.size() && startIndex < gems.length);
        

        return answer;
    }
}

// import java.util.*;

// class Solution {
//     public int[] solution(String[] gems) {
//         int[] answer = {-1,-1};
//         int minLength = 987654321;
        
//         //모든 원소 종류와 좌표 파악
//         HashMap<String, ArrayList<Integer>> map = new HashMap();
//         for(int i=0; i<gems.length; i++){
//             ArrayList<Integer> positionList = (map.get(gems[i]) == null) ? new ArrayList() : map.get(gems[i]);
//             positionList.add(i);
//             map.put(gems[i], positionList);
//         }

//         for(int i=0; i<gems.length; i++){
//             //모든 원소를 찾았는지는 set의 크기를 이용해서 체크
//             HashSet<String> set = new HashSet();
            
//             //모든 원소를 발견할 때까지, 범위 안에서
//             int scanIndex = i;
//             while(set.size() < map.size() && scanIndex < gems.length){
//                 set.add(gems[scanIndex++]);
//             }
            
//             //범위를 벗어나서 중단되었을 수도 있고
//             //모든 원소를 발견했을 수도 있으니 다시 확인
//             if(set.size() == map.size()){
//                 int length = scanIndex-i;
//                 if(minLength > length){
//                     answer[0] = i+1;
//                     answer[1] = scanIndex;
//                     minLength = length;
//                 }
//             }
//         }
        
        
//         return answer;
//     }
// }