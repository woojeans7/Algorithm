class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int max = 0;
        int i = 0;
        if(a>b){
            max = a;
            i = b;
        }
        else if(a<b){
            max = b;
            i = a;
        }
        else {
            answer = a;
            return answer;
        }
        for(; i <= max; i++){
            answer += i;
        }
        return answer;
    }
}