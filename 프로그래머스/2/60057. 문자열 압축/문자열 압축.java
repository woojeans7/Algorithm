class Solution {
    public int solution(String s) {
        int minLength = s.length(); 

        for (int i = 1; i <= s.length(); i++) {
            String[] subStr = s.split("(?<=\\G.{" + i + "})");
            StringBuilder compressed = new StringBuilder();
            String prev = subStr[0];
            int cnt = 1;

            for (int j = 1; j < subStr.length; j++) {
                if (subStr[j].equals(prev)) {
                    cnt++;
                } else {
                    if (cnt > 1) compressed.append(cnt);
                    compressed.append(prev);

                    prev = subStr[j];
                    cnt = 1;
                }
            }

            if (cnt > 1) compressed.append(cnt);
            compressed.append(prev);
            
            // System.out.println(compressed); 

            minLength = Math.min(minLength, compressed.length());
        }

        return minLength;
    }
}
