class Edge{
    String node;
    double val;

    public Edge(String node, double val){
        this.node = node;
        this.val = val;
    }
}
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] answer = new double[queries.size()];

        Map<String, Set<Edge>> graph = new HashMap<>();

        int n = values.length;

        for(int i = 0; i < n; i++){
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);

            graph.computeIfAbsent(a, k -> new HashSet<>()).add(new Edge(b, values[i]));
            graph.computeIfAbsent(b, k -> new HashSet<>()).add(new Edge(a, 1.0 / values[i]));
        }

        for(int i = 0; i < queries.size(); i++){
            Set<String> visited = new HashSet<>();

            List<String> q = queries.get(i);
            String u = q.get(0);
            String v = q.get(1);

            if (!graph.containsKey(u) || !graph.containsKey(v)) {
                answer[i] = -1.0;
                continue;
            }

            answer[i] = dfs(graph, u, v, visited);

        }

        return answer;
    }
    private double dfs(Map<String, Set<Edge>> graph, String cur, String target, Set<String> visited){
        if (!graph.containsKey(cur)) return -1.0;

        visited.add(cur);

        if(cur.equals(target)) return 1.0;


        for(Edge next : graph.get(cur)){
            String nextKey = next.node;
            double nextVal = next.val;

            if(!visited.contains(nextKey)){
                double dist = dfs(graph, nextKey, target, visited);
                if(dist != -1.0){
                    return dist * nextVal;
                }
            }
        }

        return -1.0;
    }
}