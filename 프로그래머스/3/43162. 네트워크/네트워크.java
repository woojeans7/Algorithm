class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i =0; i<n;i++){
            if(!visited[i]) {
                dfs(computers, visited, i);
                answer++;
            }   
        }
        return answer;
    }
    void dfs(int[][] computers, boolean[] visited, int curVertex){
        visited[curVertex] = true;
        
         for (int nextVertex = 0; nextVertex < computers.length; nextVertex++) {
            if (computers[curVertex][nextVertex] == 1 && !visited[nextVertex]) {
                dfs(computers, visited, nextVertex);
            }
        }
    }
}