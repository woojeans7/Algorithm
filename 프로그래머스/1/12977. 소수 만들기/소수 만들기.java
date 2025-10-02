class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                for(int k = j+1; k < nums.length; k++){
                    // 3개의 수의 합
                    int sum = nums[i]+nums[j]+nums[k];
                    // 소수 판별
                    if(isPrime(sum)){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
    
    // 소수 판별 로직
    private boolean isPrime(int num){
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}