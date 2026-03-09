class Solution {
    public int solution(String s) {
        int min =  s.length();
        
        // 압축단위를 1~n/2까지 반복
        for(int unit = 1; unit <= s.length() / 2; unit++){
            // 압축 결과
            StringBuilder compressed = new StringBuilder();
            // 처음 자른 문자
            String prev = s.substring(0, unit);
            int count = 1;
            
            // 단위만큼 반복
            for (int j = unit; j <= s.length(); j += unit) {
                // 현재 문자열
                String current = getString(s, j, unit);
                // 이전 문자와 같으면 카운트
                if (prev.equals(current)) {
                    count++;
                } 
                else {
                    // 다른 문자가 나왔다면 숫자를 문자열에 추가하고 현재 문자로 초기화
                    if (count >= 2) compressed.append(count);
                    compressed.append(prev);
                    prev = current;
                    count = 1;
                }
            }
            // 마지막 문자 처리
            if (count >= 2) compressed.append(count);
            compressed.append(prev);
            
            // 압축 최소값 갱신
            min = Math.min(min, compressed.length());
        }
        return min;
    }
    // 현재 문자가 범위를 넘어가는 것을 방지
    private String getString(String s, int start, int len) {
        if (start + len <= s.length()) {
            return s.substring(start, start + len);
        }
        return s.substring(start);
    }
}