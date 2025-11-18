class Solution {
    public boolean isPalindrome(String s) {
        s = s.toUpperCase().replaceAll("[^A-Z0-9]","");
        String temp = new StringBuilder(s).reverse().toString();
        if(s.equals(temp)) return true;

        return false;
    }
}