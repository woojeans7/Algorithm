class Solution {
    public int heightChecker(int[] heights) {
        int[] temp = heights.clone();
        Arrays.sort(temp);
        int answer = 0;
        for(int i = 0; i < heights.length; i++){
            if(temp[i] != heights[i]) answer++;
        }

        return answer;
    }
}