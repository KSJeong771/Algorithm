//https://programmers.co.kr/learn/courses/30/lessons/1835

import java.util.*;

class Solution {
    public int solution(int n, String[] data) {
        List<String> cases = new ArrayList<>();
        permutation(cases, "", "ACFJMNRT", 0, new boolean[8]);

        return cases.stream()
                .filter(s -> filtering(s, data))
                .collect(Collectors.toList())
                .size();
    }

    boolean filtering(String aCase, String[] data) {
        for (String datum : data) {
            char firstMan = datum.charAt(0);
            char secondMan = datum.charAt(2);
            int firstIndex = aCase.indexOf(firstMan);
            int secondIndex = aCase.indexOf(secondMan);

            int between = Math.abs(firstIndex - secondIndex) - 1;
            switch (datum.charAt(3)) {
                case '=':
                    if (between != datum.charAt(4)-'0') {
                        return false;
                    }
                    break;
                case '<':
                    if (between >= datum.charAt(4)-'0') {
                        return false;
                    }
                    break;
                case '>':
                    if (between <= datum.charAt(4)-'0') {
                        return false;
                    }
                    break;
            }
        }

        return true;
    }

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
}