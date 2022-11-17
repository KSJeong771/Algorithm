package reusable;

import java.util.List;

public class Permutation {
    void permutation(List<String> cases, String current, String members, int depth, boolean[] visited) {
        if (depth == members.length()) {
            cases.add(current);
            return;
        }

        for (int i = 0; i < members.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(cases, current + members.charAt(i), members, depth + 1, visited);
                visited[i] = false;
            }
        }
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
