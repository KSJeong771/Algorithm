//https://programmers.co.kr/learn/courses/30/lessons/1835

import java.util.*;
import java.util.stream.Collectors;
 
class Solution {
    public int solution(int n, String[] data) {
        List<String> permutations = new ArrayList<>();
        generateAllPermutations(permutations, "ACFJMNRT".toCharArray(), new boolean[8], "", 0);

        return permutations.stream()
                .filter(p -> filterByData(p, data))
                .collect(Collectors.toList())
                .size();
    }

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

    boolean filterByData(String permutation, String[] data) {
        for (String datum : data) {
            int firstManPosition = permutation.indexOf(datum.charAt(0));
            int secondManPosition = permutation.indexOf(datum.charAt(2));

            int membersInBetween = Math.abs(firstManPosition - secondManPosition) - 1;
            int availableNumber = datum.charAt(4) - '0';
            
            char notation = datum.charAt(3);
            switch (notation) {
                case '=':
                    if (membersInBetween != availableNumber) {
                        return false;
                    }
                    break;
                case '<':
                    if (membersInBetween >= availableNumber) {
                        return false;
                    }
                    break;
                case '>':
                    if (membersInBetween <= availableNumber) {
                        return false;
                    }
                    break;
            }
        }

        return true;
    }
}