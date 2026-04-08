class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        Queue<Integer> left = new PriorityQueue<>();
        Queue<Integer> right = new PriorityQueue<>();
        int l = 0, r = costs.length - 1;
        long ans = 0;
        while (k-- > 0) {
            while (left.size() < candidates && l <= r) left.offer(costs[l++]);
            while (right.size() < candidates && l <= r) right.offer(costs[r--]);
            if (!left.isEmpty() && !right.isEmpty())
                ans += left.peek() <= right.peek() ? left.poll() : right.poll();
            else if (!left.isEmpty())
                ans += left.poll();
            else if (!right.isEmpty())
                ans += right.poll();
        }
        return ans;
    }
}