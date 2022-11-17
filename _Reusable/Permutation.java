package reusable;

import java.util.*;

public class Permutation {
    // https://programmers.co.kr/learn/courses/30/lessons/1835
    /**
     * 배열의 원소들을 배치하여 나오는 순서의 모든 경우의 수를 구한다.
     * inputArray = {'A, 'B', 'C'}일 경우
     * permutations = {"ABC", "ACB", "BAC", "BCA", "CAB", "CBA"}이다.
     *
     * @param permutations : 결과값이 저장된다.
     * @param inputArray : 순서를 구해야 할 요소들
     * @param visited : 이미 선정된 요소를 다시 고르지 않도록 한다.
     * @param concatenatedOrder : 재귀호출 끝에서 저장될 순서
     * @param depth : 재귀호출 깊이
     */
    void generateAllPermutations(List<String> permutations,
                                 char[] inputArray,
                                 boolean[] visited,
                                 String concatenatedOrder,
                                 int depth) {
        // 순서를 저장하고 재귀호출을 종료한다.
        if (depth == inputArray.length) {
            permutations.add(concatenatedOrder);
            return;
        }

        for (int i = 0; i < inputArray.length; i++) {
            // 이미 선정된 요소를 다시 고르지 않도록 한다.
            if (!visited[i]) {
                visited[i] = true;

                // 다음 원소를 선택한다.
                String nextOrder = concatenatedOrder + inputArray[i];
                generateAllPermutations(permutations, inputArray, visited, nextOrder, depth + 1);

                // 방문 처리를 해제하는 것으로 다른 재귀호출 컨텍스트에서
                // 방문 처리 배열을 사용하는데 문제가 없도록 한다.
                visited[i] = false;
            }
        }
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/72412
    /**
     * 문자열이 선택되는 경우의 수를 미리 저장하여 탐색 속도를 높이기 위해 사용한다.
     * inputTable = {{A, B, C}, {D, E, F}}일 경우
     * cacheMap에 key인 AD, AE, AF, BD, BE, BF, CD, CE, CF에 리스트가 생성되며 각각 value가 추가된다.
     *
     * @param cacheMap : 결과값이 저장된다.
     * @param inputTable : 선택될 수 있는 모든 문자열
     * @param concatenatedKey : 재귀호출 도중 선택된 문자열들을 이어붙인 것
     * @param value : 재귀호출 끝에서 cacheMap에 저장될 값
     * @param depth : 재귀호출 깊이
     */
    void populateCacheMap(Map<String, List<Integer>> cacheMap,
                          String[][] inputTable,
                          String concatenatedKey,
                          Integer value,
                          int depth) {
        // 선택된 문자열을 Key로서 Map에 추가하고 재귀호출을 종료한다.
        if (depth == inputTable.length) {
            List<Integer> values = cacheMap.getOrDefault(concatenatedKey, new ArrayList<Integer>());
            values.add(value);

            cacheMap.put(concatenatedKey, values);
            return;
        }

        // 다음 문자열을 선택하고 재귀호출한다.
        for (int i=0; i<inputTable[depth].length; i++) {
            String nextKey = concatenatedKey + inputTable[depth][i];
            populateCacheMap(cacheMap, inputTable, nextKey, value, depth + 1);
        }
    }
}
