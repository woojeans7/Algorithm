class Solution {
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        
        boolean[] visited = new boolean[n];
        backtrack(k, n, dungeons, visited, 0);
        
        return answer;
    }
    private void backtrack(int cur, int n, int[][] dungeons, boolean[] visited, int count){
        answer = Math.max(answer, count);
        
        for(int i = 0; i < n; i++){
            if(!visited[i] && cur >= dungeons[i][0]){
                visited[i] = true;
                backtrack(cur - dungeons[i][1], n, dungeons, visited, count +1);
                visited[i] = false;
            }
        }
    }
}