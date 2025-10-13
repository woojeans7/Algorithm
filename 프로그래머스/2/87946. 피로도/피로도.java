class Solution {
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        
        // 방문 배열 초기화
        boolean[] visited = new boolean[dungeons.length];
        
        // 탐색 시작
        backtrack(k, dungeons, 0, visited);
        
        return answer;
    }
    private void backtrack(int k, int[][] dungeons, int cnt, boolean[] visited){
        
        // 1. 최대 던전 수 갱신
        answer = Math.max(answer, cnt);
        
        // 2. 던전 탐색
        for(int i = 0; i < dungeons.length; i++){
            int minP = dungeons[i][0]; // 최소 필요 피로도
            int useP = dungeons[i][1]; // 소모 필요도
            
            if(!visited[i] && k >= minP){
                visited[i] = true; // 방문표시
                backtrack(k - useP, dungeons, cnt + 1, visited);
                visited[i] = false; // 백트래킹
            }
            
        }
    }
}