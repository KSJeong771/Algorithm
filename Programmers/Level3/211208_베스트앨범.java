//https://programmers.co.kr/learn/courses/30/lessons/42579

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        //키 : 장르, 값 : 재생 횟수와 고유 인덱스
        var map = new HashMap<String, PriorityQueue<Integer[]>>();
        for(int i=0; i<plays.length; i++){
            var queue = new PriorityQueue<Integer[]>(Comparator.comparingInt(a -> -a[0]));
            
            if(map.get(genres[i]) != null)
                queue = map.get(genres[i]);
            
            queue.offer(new Integer[]{plays[i], i});
            map.put(genres[i], queue);
        }
        
        //재생 횟수의 합으로 장르 순위 매기기
        var sumOfPlays = new PriorityQueue<Integer[]>(Comparator.comparingInt(a -> -a[0]));
        for(var kv : map.entrySet()){
            int index = 0;
            int sum = 0;
            for(var play : kv.getValue()){
                index = play[1];
                sum += play[0];
            }
            sumOfPlays.add(new Integer[]{sum, index});
        }
        
        var rank = new ArrayList<Integer>();
        
        //힙을 통해 매겨진 순위대로 장르를 방문
        while(!sumOfPlays.isEmpty()){
            int genreIndex = sumOfPlays.poll()[1];
            String genreKey = genres[genreIndex];
            
            var genrePlays = map.get(genreKey);
            //최상위 재생 횟수의 고유 번호 얻기
            rank.add(genrePlays.poll()[1]);
            
            //차상위 재생 횟수의 고유 번호 얻기
            if(!genrePlays.isEmpty())
                rank.add(genrePlays.poll()[1]);
        }
        
        //answer 형식 맞추기
        int[] answer = new int[rank.size()];
        for(int i=0; i<rank.size(); i++){
            answer[i] = rank.get(i);
        }
        return answer;
    }
}