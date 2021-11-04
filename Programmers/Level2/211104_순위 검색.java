//https://programmers.co.kr/learn/courses/30/lessons/72412

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution{
	//"-"가 포함된 경우의 수만큼 해시맵에 점수를 넣는다
	public void makeInfoMap(HashMap<String, ArrayList<Integer>>[] infoMap, String[] splittedInfoItem, int point, String concatKey, int currentTry, int maxTry, int mapNumber) {
		if (currentTry >= maxTry) {
			var points = infoMap[mapNumber/2].getOrDefault(concatKey, new ArrayList<Integer>());
			points.add(point);
			infoMap[mapNumber/2].put(concatKey, points);
			return;
		}
		
		makeInfoMap(infoMap, splittedInfoItem, point, concatKey + "-", currentTry + 1, maxTry, mapNumber + (int)Math.pow(2, currentTry+1));
		makeInfoMap(infoMap, splittedInfoItem, point, concatKey + splittedInfoItem[currentTry], currentTry + 1, maxTry, mapNumber);
	}
	
	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		
		//해시맵 초기화
		int numOfHashMap = 4 * 4;
		HashMap<String, ArrayList<Integer>>[] infoMap = new HashMap[numOfHashMap];
		for (int i=0; i<numOfHashMap; i++) {
			infoMap[i] = new HashMap<String, ArrayList<Integer>>();
		}
		
		//info를 해시맵으로 가공
		//키 : 점수, 공백을 제거한 info 문자열
		//값 : 점수
		for (var infoItem : info) {
			var key = infoItem.substring(0, infoItem.lastIndexOf(' ')).split(" ");
			var point = Integer.parseInt(infoItem.substring(infoItem.lastIndexOf(' ')+1));
			
			makeInfoMap(infoMap, key, point, "", 0, key.length, 1);
		}
		
		//모든 해시맵을 정렬
		for (int i=0; i<numOfHashMap; i++) {
			infoMap[i].forEach((k, v)->{ 
				if (v.size() > 1) 
					v.sort(null);
			});
		}
		
		//쿼리문 처리
		int index = 0;
		for (var queryItem : query) {
			var key = queryItem.substring(0, queryItem.lastIndexOf(' ')).replaceAll(" and ", "");
			var splittedKey= queryItem.substring(0, queryItem.lastIndexOf(' ')).split(" and ");
			Integer point = Integer.parseInt(queryItem.substring(queryItem.lastIndexOf(' ') + 1));
			
			//쿼리문의 "-" 위치와 갯수에 따라 해시맵 번호가 달라진다.
			int group = 0;
			int splitKeyIndex = 1;
			for (var splittedKeyItem : splittedKey){
				if (splittedKeyItem.equals("-")) {
					group += splitKeyIndex;
				}
				splitKeyIndex *= 2;
			}
			
			//" and "를 제거한 문자열을 키값으로 사용하여 해시맵에서 값을 가져온다.
			ArrayList<Integer> queryResult = infoMap[group].get(key);
			
			//키에 해당되는 값이 없을 경우 처리
			if (queryResult == null || queryResult.size() <= 0) {
				answer[index++] = 0;
				continue;
			}
			
			//이진 탐색
			int searchResult = Collections.binarySearch(queryResult, point);
			//찾는 값이 있다면
			if (searchResult >= 0) {
				//가장 왼쪽에 있는 값을 얻는다
				for (int a=searchResult-1; a>=0; a--) {
				  if (queryResult.get(searchResult) - queryResult.get(a) > 0) {
					  break;
				  }
				  else {
					  searchResult = a;
				  }
				}
				answer[index++] = queryResult.size()-searchResult;
			}
			else {
				answer[index++] = queryResult.size()+searchResult+1;
			}
		}
		
        return answer;
    }
}