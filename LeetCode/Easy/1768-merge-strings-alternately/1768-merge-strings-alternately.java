class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int gap = Math.abs(len1 - len2);
        String tail = "";
        int n = len1;

        StringBuilder sb = new StringBuilder();

        if(len1 > len2){
            tail = word1.substring(len1-gap, len1);
            n = len2;
        }
        else if(len1 < len2){
            tail = word2.substring(len2-gap, len2);
        }

        for(int i = 0; i < n; i++){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        sb.append(tail);

        return sb.toString();
    }
}