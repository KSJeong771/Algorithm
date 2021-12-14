//https://programmers.co.kr/learn/courses/30/lessons/43163

import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        HashMap<String, ArrayList<String>> hash = makeHash(words);
        HashMap<String, Integer> visited = new HashMap();
        visited.put(begin, 0);
        for(var word : words)
            visited.put(word, 987654321);
        
        //변환할 수 없는 경우
        if(visited.get(target) == null)
            return 0;
        
        //dfs 탐색
        dfs(0, begin, hash, visited);
        
        return visited.get(target);
    }
    
    public void dfs(int depth, String current, HashMap<String, ArrayList<String>> hash, HashMap<String, Integer> visited){
        visited.put(current, depth);
        
        //다음 노드들 불러오기
        var nextNodes = findNext(current, hash);
        for(var nextNode : nextNodes){
            if(visited.get(nextNode) != null && visited.get(nextNode) > depth + 1){
                dfs(depth + 1, nextNode, hash, visited);
            }
        }
    }
    
    public HashMap<String, ArrayList<String>> makeHash(String[] words){
        HashMap<String, ArrayList<String>> hash = new HashMap();
        
        for(var word : words){
            for(int wildcardIndex=0; wildcardIndex<word.length(); wildcardIndex++){
                //와일드카드가 포함된 문자열 만들기
                var tempWord = word.toCharArray();
                tempWord[wildcardIndex] = '*';
                var wildcardWord = String.valueOf(tempWord);
                
                //와일드카드가 포함된 문자열과 원본 문자 목록을 같이 해시에 저장
                var wordList = new ArrayList<String>();
                if(hash.get(wildcardWord) != null)
                    wordList = hash.get(wildcardWord);
                wordList.add(word);
                hash.put(wildcardWord, wordList);
            }
        }
        
        return hash;
    }
    
    public ArrayList<String> findNext(String current, HashMap<String, ArrayList<String>> hash){
        var set = new LinkedHashSet<String>();
        for(int wildcardIndex=0; wildcardIndex<current.length(); wildcardIndex++){
            var tempWord = current.toCharArray();
            tempWord[wildcardIndex] = '*';
            var wildcardWord = String.valueOf(tempWord);
            
            if(hash.get(wildcardWord) != null){
                set.addAll(hash.get(wildcardWord));
            }
        }
        
        var result = new ArrayList<String>();
        for(var v : set)
            result.add(v);
        
        return result;
    }
}