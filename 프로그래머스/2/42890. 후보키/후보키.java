import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int n = relation.length;
        int m = relation[0].length;
        List<Integer> candidateKeys = new ArrayList<>();

        for (int bitmask = 1; bitmask < (1 << m); bitmask++) {
            if (!isMinimal(candidateKeys, bitmask)) continue;
            if (isUnique(relation, n, m, bitmask)) {
                candidateKeys.add(bitmask);
            }
        }

        return candidateKeys.size();
    }

    private boolean isMinimal(List<Integer> candidateKeys, int bitmask) {
        for (int key : candidateKeys) {
            if ((key & bitmask) == key) return false;
        }
        return true;
    }

    private boolean isUnique(String[][] relation, int n, int m, int bitmask) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m; j++) {
                if ((bitmask & (1 << j)) != 0) {
                    sb.append(relation[i][j]).append(",");
                }
            }
            set.add(sb.toString());
        }
        return set.size() == n;
    }
}