class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> map = new HashMap<>();

        for(int[] row: grid){
            String key = Arrays.toString(row);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int n = grid.length;
        int count = 0;
        
        for(int i = 0; i < n; i++){
            int[] columns = new int[n];
            
            for(int j = 0; j < n; j++){
                columns[j] = grid[j][i];
            }

            String key = Arrays.toString(columns);

            count += map.getOrDefault(key, 0);
        }

        return count;
    }
}