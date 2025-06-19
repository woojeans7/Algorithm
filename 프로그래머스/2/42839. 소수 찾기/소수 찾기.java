import java.util.*;

class Solution {
    Set<Integer> numSet = new HashSet<>();
    
    public int solution(String numbers) {
        // 문자열을 문자 배열로 변환
        char[] num = numbers.toCharArray(); 
        
        boolean[] visited = new boolean[num.length];
        
        subset(num,new StringBuilder(), visited);
        
        return countDecimal(numSet);
    }
    
    // 재귀로 가능한 모든 숫자 조합 생성
    private void subset(char[] num, StringBuilder sb, boolean[] visited){
        if (sb.length() > 0) {
            numSet.add(Integer.parseInt(sb.toString()));  // 문자 -> 숫자로 변환해서 저장
        }
        
        for(int i = 0; i < num.length; i++){
            if(!visited[i]){
                visited[i] = true;
                sb.append(num[i]);
                subset(num, sb, visited);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
    
    // 만들 수 있는 소수 카운팅
    private int countDecimal(Set<Integer> numSet){
        int count = 0;
        for(int num : numSet){
           if(isPrime(num)) count++;
        }
        return count;
    }
    
    // 소수 판별
    private boolean isPrime(int num) {
        if (num < 2) return false;  // 0과 1 제외
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;  // 나누어 떨어지면 소수 아님
        }
        return true;
    }
}