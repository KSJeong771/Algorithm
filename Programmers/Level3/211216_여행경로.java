//https://programmers.co.kr/learn/courses/30/lessons/43164#

import java.util.*;

class Solution {
    ArrayList<ArrayList<String>> paths = new ArrayList();
    public String[] solution(String[][] tickets) {
        ArrayList<String[]> ticketList = new ArrayList();
        for(var ticket : tickets){
            ticketList.add(new String[]{ticket[0], ticket[1]});
        }
        
        ArrayList<String> path = new ArrayList<String>();
        path.add("ICN");
        dfs(tickets.length, "ICN", ticketList, path);
        
        Collections.sort(paths, new Comparator<ArrayList<String>>(){
            public int compare(ArrayList<String> a, ArrayList<String> b){
                for(int i=0; i<a.size(); i++){
                    String valA = a.get(i);
                    String valB = b.get(i);
                    if(valA.equals(valB)) continue;
                    return valA.compareTo(valB);
                }
                
                return 0;
            }
        });
        
        var resultPath = paths.get(0);
        String[] answer = new String[resultPath.size()];
        for(int i=0; i<answer.length; i++)
            answer[i] = resultPath.get(i);
        
        return answer;
    }
    
    public void dfs(int count, String current, ArrayList<String[]> ticketList, ArrayList<String> path){
        if(count == 0){
            paths.add(path);
            return;
        }
        
        for(int i=0; i<ticketList.size(); i++){
            if(!current.equals(ticketList.get(i)[0])){
                continue;
            }
            
            String next = ticketList.get(i)[1];
            
            //deep copy ticketList
            ArrayList<String[]> newTicketList = new ArrayList();
            newTicketList.addAll(ticketList);
            newTicketList.remove(i);
            
            //deep copy path
            ArrayList<String> newPath = new ArrayList();
            newPath.addAll(path);
            newPath.add(next);
            
            dfs(count-1, next, newTicketList, newPath);
        }
    }
}