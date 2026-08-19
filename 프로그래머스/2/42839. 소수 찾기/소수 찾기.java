import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int n = numbers.length();
        boolean[] visited = new boolean[n];
        permutation(numbers, visited, n, "");
        return set.size();
    }
    private void permutation(String numbers, boolean[] visited, int n, String cur){
        if(cur.length() > 0){
            int num = Integer.parseInt(cur);
            if(isPrime(num)) set.add(num);
        }
        
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            permutation(numbers, visited, n, cur + numbers.charAt(i));
            visited[i] = false;
        }
    }
    private boolean isPrime(int num){
        if(num < 2) return false;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}