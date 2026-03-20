class Solution {
    public String removeStars(String s) {
        char[] arr = s.toCharArray();
        int index = 0;
        if (arr.length == 1) return s;
        for (int i = 0; i < arr.length; i++) {
            if (s.charAt(i) == '*') index--;
            else arr[index++] = s.charAt(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}