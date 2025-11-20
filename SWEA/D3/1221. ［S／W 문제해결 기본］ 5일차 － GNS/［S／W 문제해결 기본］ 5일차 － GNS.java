import java.util.*;
import java.io.*;

public class Solution {
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map.put("ZRO", 0);
        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put("THR", 3);
        map.put("FOR", 4);
        map.put("FIV", 5);
        map.put("SIX", 6);
        map.put("SVN", 7);
        map.put("EGT", 8);
        map.put("NIN", 9);

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String tc =  st.nextToken();
            int len = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            String[] str =  new String[len];
            for(int i = 0; i < len; i++){
                str[i] = st.nextToken();
            }
            Arrays.sort(str, Comparator.comparing(a -> map.get(a)));

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < len; i++){
                sb.append(str[i] + " ");
            }
            System.out.println(tc);
            System.out.println(sb);
        }
    }
}
