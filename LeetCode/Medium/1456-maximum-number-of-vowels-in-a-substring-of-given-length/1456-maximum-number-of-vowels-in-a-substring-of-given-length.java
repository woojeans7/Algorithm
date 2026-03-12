class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a','e','i','o','u');

        int n = s.length();
        int count = 0;
        for(int i = 0; i < k; i++){
            if(vowels.contains(s.charAt(i))) count++;
        }

        int maxCount = count;

        for(int i=k; i < n; i++){
            if(vowels.contains(s.charAt(i))) count++;
            if(vowels.contains(s.charAt(i-k))) count --;
            maxCount = Math.max(count, maxCount);
        }

        return maxCount;   
    }
}