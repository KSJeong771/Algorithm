//https://programmers.co.kr/learn/courses/30/lessons/64064

import java.util.*;

class Solution {
    //완전탐색 결과에서 중복을 제외하기 위해 set을 사용한다.
    HashSet<String> dfsResult = new HashSet();
    
    public int solution(String[] user_id, String[] banned_id) {
        //불량 사용자 패턴과 일치하는 사용자명 목록을 만든다.
        HashMap<String, TreeSet<String>> patternMatchedUserId = new HashMap();
        
        for(var banId : banned_id){
            for(var userId : user_id){
                if(banId.length() != userId.length()) continue;
                
                boolean matched = true;
                for(int i=0; i<banId.length(); i++){
                    if(banId.charAt(i) == '*') continue;
                    if(banId.charAt(i) == userId.charAt(i)) continue;
                    matched = false;
                    break;
                }
                
                if(matched) {
                    var list = (patternMatchedUserId.get(banId) == null) 
                                ? new TreeSet<String>() 
                                : patternMatchedUserId.get(banId);
                    list.add(userId);
                    patternMatchedUserId.put(banId, list);
                }
            }
        }
        
        
        //불량 사용자 패턴과 일치하는 사용자명 목록을 완전탐색하여 경우의 수를 조사한다.
        int depth = 0;
        for(var userId : patternMatchedUserId.get(banned_id[depth])){
            TreeSet<String> visited = new TreeSet();
            visited.add(userId);
            dfs(depth, patternMatchedUserId, banned_id, visited);
        }
        
        return dfsResult.size();
    }
    
    
    public void dfs(int depth, HashMap<String, TreeSet<String>> patternMatchedUserId, String[] banned_id, TreeSet<String> visited){
        depth++;
        if(depth >= banned_id.length) {
            //끝까지 탐색하는 데 성공했을 때 set을 이용해 중복된 결과를 제외한다.
            String temp = "";
            for(var v : visited){
                temp += v;
            }
            
            dfsResult.add(temp);
            return;
        }
        
        //다음 불량 사용자 패턴을 조사한다.
        for(var userId : patternMatchedUserId.get(banned_id[depth])){
            if(visited.contains(userId)) continue;
            
            TreeSet<String> newVisited = new TreeSet();
            for(var v : visited)
                newVisited.add(v);
            newVisited.add(userId);
            
            dfs(depth, patternMatchedUserId, banned_id, newVisited);
        }
    }
}