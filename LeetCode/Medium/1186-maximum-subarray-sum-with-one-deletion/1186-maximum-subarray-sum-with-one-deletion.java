class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;

        int[] noDelete = new int[n];
        int[] oneDelete = new int[n];
        
        noDelete[0] = arr[0];
        oneDelete[0] = Integer.MIN_VALUE / 2;
        for(int i = 1; i < n; i++){
            noDelete[i] = Math.max(arr[i], noDelete[i-1] + arr[i]);
            oneDelete[i] = Math.max(noDelete[i-1], oneDelete[i-1] + arr[i]);
        }

        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            answer = Math.max(answer, Math.max(noDelete[i], oneDelete[i]));
        }

        return answer;
    }
}