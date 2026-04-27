class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int answer = 0;
        for(int key : map.keySet()){
            if(map.get(key) > nums.length / 2){
                answer = key;
            }
        }

        return answer;
    }
}