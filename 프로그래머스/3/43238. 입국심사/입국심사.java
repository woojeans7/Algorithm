import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        return binarySearch(times, n, times[times.length - 1]);
    }
    private long binarySearch(int[] times, int n, long max){
        long left = 1, right = max * n;
        long mid = 0;
        long ans = Long.MAX_VALUE;
        
        while(left <= right){
            mid = (left + right) / 2;
            
            if(isPassed(times, n, mid)){
                ans = ans > mid ? mid : ans;
                right = mid - 1;
            }
            else{
                left = mid + 1;   
            }
        }
        
        return ans;
        
    }
    private boolean isPassed(int[] times, int n, long mid){
        long amount = 0;
        
        for(int i = 0; i < times.length; i++){
            amount += mid / times[i];
        }
        if(amount >= n) return true;
        
        return false;
    }
}