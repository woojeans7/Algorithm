import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        int k = nums.length / 2;
        
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        // System.out.println("최대 폰켓몬 수 : " + k);
        // System.out.println("중복제거 : " + set.size());
        return Math.min(k, set.size());
    }
}