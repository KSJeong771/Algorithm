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
}
