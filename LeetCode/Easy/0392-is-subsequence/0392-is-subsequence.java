class Solution {
    public boolean isSubsequence(String s, String t) {
        int count = 0;
        int idx = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            for (int j = idx; j < t.length(); j++) {
                if (t.charAt(j) == c) {
                    idx = j + 1;
                    count++;
                    break;
                }
            }
        }

        if (count == s.length()) {
            return true;
        } else {
            return false;
        }
    }
}