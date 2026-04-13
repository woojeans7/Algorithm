class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> answer = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        
        backtrack(0, digits, sb, answer, map);

        return answer;
    }
    private void backtrack(int idx, String digits, StringBuilder cur, List<String> answer, Map<Character, String> map){
        if(idx == digits.length()){
            answer.add(cur.toString());
            return;
        }

        for(char c : map.get(digits.charAt(idx)).toCharArray()){
            cur.append(c);
            backtrack(idx+1, digits, cur, answer, map);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}