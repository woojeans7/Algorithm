class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        int[] degree = new int[numCourses];

        for(int[] p : prerequisites){
            int a = p[0];
            int b = p[1];

            graph.get(b).add(a);
            degree[a]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < numCourses; i++){
            if(degree[i] == 0){
                queue.offer(i);
            }
        }

        List<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()){
            int cur = queue.poll();
            answer.add(cur);

            for(int next : graph.get(cur)){
                degree[next]--;
                if(degree[next] == 0){
                    queue.offer(next);
                }
            }
        }

        return answer.size() == numCourses 
            ? answer.stream().mapToInt(i -> i).toArray() 
            : new int[0];
    }
}