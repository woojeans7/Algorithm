import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 1. 숫자를 문자열로 변환
        String[] strs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }

        // 2. 붙였을 때 더 큰 쪽이 앞에 오도록 정렬
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        // 3. 가장 앞이 "0"이면 전부 0이므로 "0" 반환
        if (strs[0].equals("0")) return "0";

        // 4. 이어 붙이기
        StringBuilder sb = new StringBuilder();
        for (String s : strs) sb.append(s);
        return sb.toString();
    }
}