class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Set<String> set = new HashSet<>();
        int n = s.length();
        int m = p.length();

        List<Integer> answer = new ArrayList<>();

        String newP = sort(p);
        set.add(newP);
        for(int i = 0; i <= n-m; i++){
            String str = sort(s.substring(i, i+m));
            if(set.contains(str)){
                answer.add(i);
            }
        }

        return answer;

    }
    private String sort(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}