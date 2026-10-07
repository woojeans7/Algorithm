class Solution {
    public int compress(char[] chars) {
        
        int i = 0;
        int count = 0;
        StringBuilder result = new StringBuilder();

        while(i < chars.length){
            char cur = chars[i];

            while(i < chars.length && cur == chars[i]){
                i++;
                count++;
            }

            result.append(cur);
            if(count > 1) result.append(count);

            count = 0;
        }

        String answer = result.toString();

        for(int j = 0; j < answer.length(); j++){
            chars[j] = answer.charAt(j);
        }

        return answer.length();
    }
}