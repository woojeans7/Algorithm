class Solution {
    public int solution(int[] money) {
        int n = money.length;
        
        if(n == 0) return 0;
        if(n == 1) return money[0];
        
        // dp
        int[] odd = new int[n];
        int[] even = new int[n];
        
        // 첫 집을 터는 경우
        odd[0] = money[0];
        odd[1] = money[0];  
        
        // 첫 집을 털지 않는 경우
        even[1] = money[1];

        for(int i = 2; i < n; i++){
            odd[i] = Math.max(odd[i-1], odd[i-2] + money[i]);
            even[i] = Math.max(even[i-1], even[i-2] + money[i]);
        }
        
        return Math.max(odd[n-2], even[n-1]);     
    }
}