class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int n = sequence.length;
        int left = 0, right = 0;
        int sum = sequence[0];
        int min = n + 1;
        
        while(right < n){
            // 합이 k보다 작으면 계속 더해줘야 함.
            if(sum < k){
                right++;
                if(right ==  n) break; // 범위 체크
                sum += sequence[right];
            }
            // k보다 크면 시작점을 조절해야 함.
            else if(sum > k){
                sum -= sequence[left];
                left++;
            }
            // 같을 경우 종료
            else{
                int len = right - left;
                // 길이가 최소값일 때
                if(len < min){
                    answer[0] = left;
                    answer[1] = right;
                    min = len;
                }
                // 다른 구간이 더 있을 수도 있어서 재탐색
                sum -= sequence[left];
                left++; 
            }
            
        }
        return answer;
    }
}