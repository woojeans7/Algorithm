class Solution {
    public String decodeString(String s) {
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();
        StringBuilder cur = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(cur);
                num = 0;
                cur = new StringBuilder();
            } else if (c == ']') {
                int repeat = numStack.pop();
                StringBuilder prev = strStack.pop();
                for (int i = 0; i < repeat; i++) {
                    prev.append(cur);
                }
                cur = prev;
            } else {
                cur.append(c);
            }
        }
        return cur.toString();
    }
}