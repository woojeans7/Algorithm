class Solution {
    int cnt = 0;
    int[] tmp;
    public int solution(int n) {
        tmp = new int[n];
        backtrack(0, n);
        return cnt;
    }
    private void backtrack(int k, int n){
        if(k == n){
            cnt++;
            return;
        }
        for(int i = 0; i < n; i++){
            tmp[k] = i;
            if(check(k)){
                backtrack(k+1, n);
            }
        }
    }
    private boolean check(int row){
        for(int i = 0; i < row; i++){
            if(tmp[i] == tmp[row]) return false;
            if(Math.abs(row-i) == Math.abs(tmp[row]-tmp[i])) return false;
        }
        return true;
    }
}