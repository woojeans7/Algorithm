import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // 원하는 상품 -> 필요 수량
        Map<String, Integer> needMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            needMap.put(want[i], number[i]);
        }

        // 현재 윈도우 내 상품 카운트
        Map<String, Integer> windowMap = new HashMap<>();
        int matched = 0;

        for (int i = 0; i < discount.length; i++) {
            // === 오른쪽 원소 추가 ===
            String addItem = discount[i];
            windowMap.put(addItem, windowMap.getOrDefault(addItem, 0) + 1);
            // 카운트가 정확히 필요 수량에 도달한 순간만 matched 증가
            if (needMap.containsKey(addItem)
                    && windowMap.get(addItem).equals(needMap.get(addItem))) {
                matched++;
            }

            // === 윈도우 크기 10 초과 시 왼쪽 원소 제거 ===
            if (i >= 10) {
                String removeItem = discount[i - 10];
                // 제거 전에 확인: 지금 딱 맞는 상태였으면 matched 감소
                if (needMap.containsKey(removeItem)
                        && windowMap.get(removeItem).equals(needMap.get(removeItem))) {
                    matched--;
                }
                windowMap.put(removeItem, windowMap.get(removeItem) - 1);
            }

            // === 윈도우 크기가 정확히 10일 때 판단 ===
            if (i >= 9 && matched == needMap.size()) {
                answer++;
            }
        }

        return answer;
    }
}