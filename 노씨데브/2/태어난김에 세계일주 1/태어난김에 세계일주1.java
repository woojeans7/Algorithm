class Solution {
    private int answer;

    public int solution(int balance, int[][] countries) {
        answer = 0;
        boolean[] visited = new boolean[countries.length];
        dfs(balance, countries, 0, visited);
        return answer;
    }

    public void dfs(int balance, int[][] countries, int count, boolean[] visited) {
        answer = Math.max(answer, count);

        for (int i = 0; i < countries.length; i++) {
            if (balance >= countries[i][1] && !visited[i]) {
                visited[i] = true;
                dfs(balance - countries[i][0], countries, count + 1, visited);
                visited[i] = false;
            }
        }
    }
}