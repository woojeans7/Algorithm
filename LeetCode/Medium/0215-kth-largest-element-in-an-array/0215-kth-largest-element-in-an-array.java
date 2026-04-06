class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int n : nums) {
           pq.add(n);
        }           

        int i = 0;
        int answer = 0;
        while(i < k){
            answer = pq.poll();
            i++;
        }

        return answer;
    }
}