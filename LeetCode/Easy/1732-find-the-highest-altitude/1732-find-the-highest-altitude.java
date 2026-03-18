class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;

        int[] altitude = new int[n+1];
        altitude[0] = 0;

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += gain[i];
            altitude[i+1] = sum;
        }

        int answer = -101;
        for(int i = 0; i <= n; i++){
            answer = Math.max(answer, altitude[i]);
        }

        return answer;
    }
}