class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] sports = new int[n];
        
        for(int i = 0; i < n; i++){
            sports[i] = 1;
        }
        
        for(int l : lost){
            sports[l-1] -= 1;
        }
        
        for(int r : reserve){
            sports[r-1] += 1;
        }
        
        for(int i = 0; i < n; i++){
            if(sports[i] == 0){
                // 앞번호한테 빌리기
                if(i - 1 >= 0 && sports[i - 1] == 2){
                    sports[i]++;
                    sports[i - 1]--;
                }
                // 뒷번호한테 빌리기
                else if (i + 1 < n && sports[i + 1] == 2) {
                    sports[i]++;
                    sports[i + 1]--;
                }
            }
            
        }
        // 체육복이 1벌 이상인 학생 수 세기
        for (int i = 0; i < n; i++) {
            if (sports[i] >= 1) answer++;
        }

        return answer;
    }
}