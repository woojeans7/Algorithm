class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) numSet.add(n);

        int longest = 0;

        // 중복이 제거된 집합을 순회
        for (int n : numSet) {
            // 시작점이 아니면 건너뜀
            if (numSet.contains(n - 1)) continue;

            int len = 1;
            while (numSet.contains(n + len)) len++;

            longest = Math.max(longest, len);
        }
        return longest;
    }
}