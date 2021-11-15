//https://programmers.co.kr/learn/courses/30/lessons/42890#

import java.util.*;

class Solution {
    ArrayList<String> indexList = new ArrayList<String>();
    
    public int solution(String[][] relation) {
        //1~n개 뽑는 경우의 수 구하기
        for(int i=0; i < relation[0].length; i++){
            for(int n=1; n<=relation[0].length; n++){
                makeIndexList(i, n, "", new int[relation[0].length]);
            }
        }
        
        //짧은 것 부터 탐색하면서 후보키를 등록해야
        //긴 것을 탐색할 때 후보키를 포함하고 있는 조합을 걸러낼 수 있다
        Collections.sort(indexList, new Comparator<String>(){
           @Override
            public int compare(String s1, String s2){
                return s1.length() - s2.length();
            }
        });
        
//         for(var v : indexList)
//             System.out.println(v);
        
        
        ArrayList<String> candidateKey = new ArrayList();
        
        for(String indexStr : indexList){
            boolean isCandidate = false;
            
            for(String candidateIndex : candidateKey){
                int bit1 = 0;
                int bit2 = 0;
                
                for(int i=0; i<candidateIndex.length(); i++)
                    bit1 += 1 << (Integer.parseInt(candidateIndex.substring(i, i+1)));
                for(int i=0; i<indexStr.length(); i++)
                    bit2 += 1 << (Integer.parseInt(indexStr.substring(i, i+1)));
                    
                if((bit1 & bit2) == bit1) 
                    isCandidate = true;
            }
            
            if(isCandidate) 
                continue;
            
            if(isUniqueKey(indexStr, relation))
                candidateKey.add(indexStr);
        }
        
        //     System.out.println("-----------------");
        // for(var v : candidateKey)
        //     System.out.println(v);
        
        return candidateKey.size();
    }
    
    //중복 없이 n개 뽑기
    public void makeIndexList(int currentIndex, int n, String pickedStr, int[] visited){
        visited[currentIndex] = 1;
        pickedStr += String.valueOf(currentIndex);
        
        if(pickedStr.length() >= n){
            indexList.add(pickedStr);
            return;
        }
        
        for(int i=currentIndex; i<visited.length; i++)
            if(visited[i] == 0)
                makeIndexList(i, n, pickedStr, visited.clone());
    }
    
    //모든 row를 돌면서 조합한 값이 중복되는지를 확인
    //다 돌았을 때 중복되지 않으면 카운트 증가
    public boolean isUniqueKey(String indexes, String[][] relation){
        HashMap<String, Integer> duplicateFilter = new HashMap<String, Integer>();
        
        for(int row=0; row<relation.length; row++){
            String key = "";
            for(int i=0; i<indexes.length(); i++){
                int column = Integer.parseInt(indexes.substring(i, i+1));
                key += relation[row][column];
            }
            
            if (duplicateFilter.get(key) != null)
                //조합한 키가 중복됨
                return false;
            else
                //조합한 키가 중복되지 않음
                duplicateFilter.put(key, 1);
        }
        
            System.out.println("r------------------UNIQUE");
        for(var v : duplicateFilter.entrySet())
            System.out.println(v.getKey());
            System.out.println("ㄴ------------------UNIQUE");
            
        //조합한 모든 키가 중복되지 않음
        return true;
    }
}