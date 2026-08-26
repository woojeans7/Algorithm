class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < number.length(); i++) {
            char cur = number.charAt(i);
            
            // while문으로 앞의 더 작은 수들을 연속해서 제거
            while (sb.length() > 0 && cur > sb.charAt(sb.length() - 1) && k > 0) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(cur);
        }
        
        // k가 여전히 남아있는 경우 뒤에서부터 k개 잘라내기
        return sb.substring(0, sb.length() - k);
    }
}