class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles);

        while (left < right) {
            int mid = (left + right) / 2;
            // mid 속도로 먹었을 때 총 소요 시간 계산
            if (getTotalTime(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
    private int getMax(int[] nums) {
        int max = 0;
        for (int n : nums) {
            max = Math.max(max, n);
        }
        return max;
    }
    private int getTotalTime(int[] piles, int k) {
        int time = 0;
        for (int pile : piles) {
            time += (pile + k - 1) / k;
        }
        return time;
    }
}