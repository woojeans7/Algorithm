import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {

        List<String> answer = new ArrayList<>();

        Map<String, List<String>> graph = new HashMap<>();

        for(String[] ticket : tickets){
            String from = ticket[0];
            String to = ticket[1];

            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(to);
        }

        for(List<String> list : graph.values()){
            Collections.sort(list);
        }

        Map<String, boolean[]> visited = new HashMap<>();
        for(String from : graph.keySet()){
            visited.put(from, new boolean[graph.get(from).size()]);
        }

        int n = tickets.length;
        answer.add("ICN");
        dfs(graph, visited, "ICN", n, answer);


        return answer.toArray(new String[0]);
    }
    private boolean dfs(Map<String, List<String>> graph, Map<String, boolean[]> visited, String cur, int n, List<String> path){
        if(path.size() == n + 1) return true;

        List<String> destinations = graph.get(cur);
        if(destinations == null || destinations.isEmpty()) return false;
        boolean[] used = visited.get(cur);

        for(int i = 0; i < destinations.size(); i++){
            if(used[i]) continue;

            used[i] = true;
            path.add(destinations.get(i));
            if(dfs(graph, visited, destinations.get(i), n, path)) return true;
            path.remove(path.size() - 1);
            used[i] = false;
        }

        return false;
    }
}