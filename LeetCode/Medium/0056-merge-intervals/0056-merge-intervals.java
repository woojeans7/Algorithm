class Solution {
    public int[][] merge(int[][] intervals) {
        // base case
        int n = intervals.length;
        if(n == 1) return intervals;

        // 시작 시간 기준으로 구간 정렬 
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // 스택 생성
        Stack<int[]> stack = new Stack<>();

        // 첫 번째 간격을 스택에 추가
        stack.add(intervals[0]);

        // 간격 병합
        for(int i = 1; i < n; i++){
            int[] prev = stack.peek();
            int[] cur = intervals[i];

            // 겹치는지 체크
            if(prev[1] < cur[0]){
                stack.add(cur);
            }
            else prev[1] = Math.max(cur[1], prev[1]);
        }

        return stack.toArray(new int[stack.size()][2]);
        
    }
}