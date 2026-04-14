class Solution {
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        boolean[] visited = new boolean[dungeons.length];
        backtrack(k, dungeons, visited, 0);
        
        return answer;
    }
    private void backtrack(int cur, int[][] dungeons, boolean[] visited, int cnt){
        
        answer = Math.max(answer, cnt);
        
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && cur >= dungeons[i][0]){
                visited[i] = true;
                backtrack(cur-dungeons[i][1], dungeons, visited, cnt+1);
                visited[i] = false;
            }
        }
    }
}