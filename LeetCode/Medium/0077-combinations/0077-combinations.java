import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combination(answer, list, 1, n, k);
        return answer;
    }

    public void combination(List<List<Integer>> answer, List<Integer> list, int s, int n, int k){
        if(k == 0){
            answer.add(new ArrayList<>(list));
            return;
        }
        for(int i = s; i <= n; i++){
                list.add(i);
                combination(answer,list,i+1, n, k-1);
                list.remove(list.size()-1);
        }
    }
}