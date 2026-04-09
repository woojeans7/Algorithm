class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);

        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            long minPotion = (success + spells[i] - 1) / spells[i];
            int idx = search(potions, minPotion);
            answer[i] = m - idx;
        }
        return answer;
    }
    private int search(int[] arr, long target){
        int left = 0;
        int right = arr.length;
        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] >= target){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}