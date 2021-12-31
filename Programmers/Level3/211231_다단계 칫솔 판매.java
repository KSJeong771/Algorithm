//https://programmers.co.kr/learn/courses/30/lessons/77486#

import java.util.*;

class Solution {
    int[] answer;
    HashMap<String, String> parentMap = new HashMap();
    HashMap<String, Integer> indexMap = new HashMap();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];

        //부모 노드 찾는 시간 줄이기
        for(int i=0; i<enroll.length; i++){
            parentMap.put(enroll[i], referral[i]);
        }

        //문자열로 바로 인덱스 찾을 수 있게 해두기
        for(int i=0; i<enroll.length; i++){
            indexMap.put(enroll[i], i);
        }
        
        //모든 판매 수익 발생한 건에 대해 재귀 수행
        for(int i=0; i<seller.length; i++){
            func(seller[i], amount[i] * 100);
        }

        return answer;
    }
    
    public void func(String seller, int amount){
        if(seller.equals("-"))
            return;
        
        int remainder = amount / 10;
        amount -= remainder;
        answer[indexMap.get(seller)] += amount;
        
        if(remainder > 0)
            func(parentMap.get(seller), remainder);
    }
}

//모든 판매 수익이 각각 절사되어야 오답이 나오지 않는다.
//탑다운 방식으로는 시간을 맞출 수가 없음
// import java.util.*;

// class Solution {
//     public int func(String self, String[] enroll, String[] referral, HashMap<String, Integer> sellMap){
//         int money = 0;
//         if(sellMap.get(self) != null){
//             money = sellMap.get(self);
//         } 
        
//         for(var child : getChildren(self, enroll, referral)){
//             money += func(child, enroll, referral, sellMap);
//         }
        
//         int remainder = money / 10;
//         money -= remainder;
        
//         sellMap.put(self, money);
        
//         return remainder;
//     }
    
//     public ArrayList<String> getChildren(String self, String[] enroll, String[] referral){
//         ArrayList<String> children = new ArrayList();
        
//         for(int i=0; i<referral.length; i++){
//             if(self.equals(referral[i])){
//                 children.add(enroll[i]);
//             }
//         }
        
//         return children;
//     }
    
//     public HashMap<String, Integer> getSellMap(String[] enroll, String[] seller, int[] amount, int[] visitedSeller){
//         var map = new HashMap<String, Integer>();
        
//         for(int i=0; i<seller.length; i++){
//             if(visitedSeller[i] > 0) continue;
//             if(map.get(seller[i]) != null) continue;
//             visitedSeller[i] = 1;
//             map.put(seller[i], amount[i] * 100);
//         }
        
//         return map;
//     }
    
//     public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
//         int[] answer = new int[enroll.length];
        
//         int[] visitedSeller = new int[seller.length];
//         var sellMap = getSellMap(enroll, seller, amount, visitedSeller);
//         while(sellMap.size() > 0){
//             func("-", enroll, referral, sellMap);
            
//             System.out.println("-=--=-=-=-=-=-=");
//             for(int i=0; i<enroll.length; i++){
//                 if(sellMap.get(enroll[i]) != null)
//                     answer[i] += sellMap.get(enroll[i]);
//             }
            
//             for(var v : sellMap.entrySet()){
//                 System.out.println(v);
//             }
//             sellMap = getSellMap(enroll, seller, amount, visitedSeller);
//         }
        
//         return answer;
//     }
// }