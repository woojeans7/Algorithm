class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int n = number.length;
        
        int sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                for(int k = j+1; k < n; k++){
                    sum = number[i] + number[j] + number[k];
                    if(sum == 0) answer++;
                }
            }
        }
        
        return answer;
    }
}