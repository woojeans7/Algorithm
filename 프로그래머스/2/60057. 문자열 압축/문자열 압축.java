class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int i = 1; i < s.length() / 2 + 1; i++){
            answer = Math.min(answer, compress(s, i));
        }
        return answer;
    }
    public int compress(String s, int length){
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        
        String prev = s.substring(0, length);
        int count = 1;
        
        for(int i = length; i < len; i += length){
            String unit = s.substring(i, Math.min(i + length, len));
            if (unit.equals(prev)) {
                count++;
            } else {
                if (count > 1) sb.append(count);
                sb.append(prev);
                prev = unit;
                count = 1;
            }
        }
        if (count > 1) sb.append(count);
        sb.append(prev);
        
        return sb.toString().length();
    }
}