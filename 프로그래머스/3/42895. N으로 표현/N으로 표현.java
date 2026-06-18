import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // 괄호 ()와 사칙연산  +,-,/,* 만 사용해서 N만 가지고 number를 만드는 문제
        // 1부터 number까지 만들 수 있는 경우의 수
        if (N == number) return 1;

        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(null);

        for(int k = 1; k <= 8; k++){
            Set<Integer> set = new HashSet<>();

            int concat = 0;
            for (int i = 0; i < k; i++) {
                concat = concat * 10 + N;
            }
            set.add(concat);

            for (int i = 1; i < k; i++) {
                for (int a : dp.get(i)) {
                    for (int b : dp.get(k - i)) {
                        set.add(a + b);
                        set.add(a - b);
                        set.add(a * b);
                        if (b != 0) set.add(a / b);
                    }
                }
            }

            if (set.contains(number)) return k;
            dp.add(set);

        }
        return -1;
    }
}
