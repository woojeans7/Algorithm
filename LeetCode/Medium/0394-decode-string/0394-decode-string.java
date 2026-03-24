class Solution {
    public String decodeString(String s) {
        Deque<String> strStack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        int num = 0;

        for(char c : s.toCharArray()){
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            else if(c == '['){
                strStack.push(sb.toString());
                numStack.push(num);
                num = 0;
                sb = new StringBuilder();
            }
            else if(c == ']'){
                int n = numStack.pop();
                String prev = strStack.pop();

                String repeated = sb.toString().repeat(n);
                sb = new StringBuilder(prev + repeated);
            }
            else{
                sb.append(c);
            }
        }

        return sb.toString();
    }
}