class Solution {
    public int compress(char[] chars) {
        int idx = 0;
        int i = 0;

        while(i < chars.length){
            char prev = chars[i];
            int count = 0;


            while(i < chars.length && chars[i] == prev){
                i++;
                count++;
            }

            chars[idx++] = prev;
            if(count > 1){
                for(char ch : Integer.toString(count).toCharArray()){
                    chars[idx++] = ch;
                }
            }
        }
        
        return idx;
    }
}