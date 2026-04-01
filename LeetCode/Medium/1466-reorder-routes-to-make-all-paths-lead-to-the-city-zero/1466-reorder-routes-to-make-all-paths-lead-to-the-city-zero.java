class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        // 인접리스트 초기화
        for(int[] connection : connections){
            int a = connection[0];
            int b = connection[1];

            graph.get(a).add(new int[]{b,1});
            graph.get(b).add(new int[]{a, 0});
        }

        Set<Integer> visited = new HashSet<>();

        return dfs(graph, 0, visited);

    }
    private int dfs(List<List<int[]>> graph, int cur, Set<Integer> visited){
        visited.add(cur);
        int count = 0;

        for(int[] next : graph.get(cur)){
            if(!visited.contains(next[0])){
                count += next[1];
                count += dfs(graph, next[0], visited);
            }
        }

        return count;
    }
}