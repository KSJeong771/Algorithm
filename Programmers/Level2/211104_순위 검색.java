// https://school.programmers.co.kr/learn/courses/30/lessons/72412

import java.util.*;

class Solution {
    
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> cacheMap = new HashMap();
        for (var eachInfo : info) {
            // 점수와 칼럼 정보를 분리한다.
            int pointIndex = eachInfo.lastIndexOf(" ");
            Integer point = Integer.parseInt(eachInfo.substring(pointIndex + 1, eachInfo.length()));
            String columnInfo = eachInfo.substring(0, pointIndex);
            
            // 와일드카드를 포함한 테이블을 만든다.
            String[][] tableWithWildcard = new String[4][2];
            String[] columnElements = columnInfo.split(" ");
            for (int i=0; i<4; i++) {
                tableWithWildcard[i][0] = columnElements[i];
                tableWithWildcard[i][1] = "-";
            }
            
            // 테이블의 문자열이 선택되는 경우의 수마다 점수를 저장한다.
            populateCacheMap(cacheMap, tableWithWildcard, "", point, 0);
        }
        
        // 점수를 정렬한다.
        cacheMap.forEach((k, v) -> Collections.sort(v));
        
        // 쿼리문 처리
        int[] result = new int[query.length];
        for (int i=0; i<query.length; i++) {
            // 점수와 칼럼 정보를 분리한다.
            int pointIndex = query[i].lastIndexOf(" ");
            Integer point = Integer.parseInt(query[i].substring(pointIndex + 1, query[i].length()));
            String columnInfo = query[i].substring(0, pointIndex);
            // System.out.println("point : " + point);
            
            // 칼럼 정보를 키로 사용하여 점수 목록을 찾는다.
            String key = columnInfo.replace(" and ", "");
            List<Integer> points = cacheMap.getOrDefault(key, new ArrayList<Integer>());
            
            // 기준보다 높은 점수를 받은 사람 수를 찾는다
            int position = Collections.binarySearch(points, point);
            if (position >= 0) {
                // 기준과 같은 점수를 발견했다면 그 점수와 같은 점수가 위치한 최초의 인덱스를 찾아야 한다.
                for (int i=position-1; i>=0; i--) {
                    if (!points.get(a).equals(point)) {
                        break;
                    }
                    position = i;
                }
                result[i] = points.size() - position;
            } else {
                // 기준과 같은 점수가 없다면 그 다음 위치부터 몇 명이 있는지 세면 된다.
                // binarySearch는 대상이 없을 경우 기준 점수가 들어갈 위치 -1을 음수로 반환하므로 양수로 변환한다.
                result[i] = points.size() + (position + 1);
            }
        }
        return result;
    }
    
    /**
     * 문자열이 선택되는 경우의 수를 미리 저장하여 탐색 속도를 높이기 위한 함수
     * @param cacheMap : 결과값이 저장된다.
     * @param table : 선택될 수 있는 모든 문자열
     * @param concatenatedKey : 재귀호출 도중 선택된 문자열들을 이어붙인 것
     * @param value : 재귀호출 끝에서 cacheMap에 저장될 값
     * @param depth : 재귀호출 깊이
     */
    void populateCacheMap(Map<String, List<Integer>> cacheMap,
                          final String[][] table,
                          String concatenatedKey,
                          Integer value,
                          int depth) {
        // 선택된 문자열을 Key로서 Map에 추가하고 재귀호출을 종료한다.
        if (depth == table.length) {
            List<Integer> values = cacheMap.getOrDefault(concatenatedKey, new ArrayList<Integer>());
            values.add(value);
            cacheMap.put(concatenatedKey, values);
            return;
        }

        // 다음 문자열을 선택하고 재귀호출한다.
        for (int i=0; i<table[depth].length; i++) {
            String nextKey = concatenatedKey + table[depth][i];
            populateCacheMap(cacheMap, table, nextKey, value, depth + 1);
        }
    }
}