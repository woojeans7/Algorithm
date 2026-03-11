class Solution {
    public int maxArea(int[] height) {
        // 길이 N의 높이가 담겨있는 배열이 주어짐
        // i 인덱스가 x좌표임, (i, height[i]) 
        // (i, 0) 0번째는 0
        // 가장 넓은 면적이 될 때 면적을 반환하는 문제

        int n = height.length;
        int left = 0;
        int right = n-1;

        int maxArea = 0;
        
        while(left < right){
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);

            if(height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }
}