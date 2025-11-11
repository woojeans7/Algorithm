import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> temp = new HashSet<>();

        for (int i = 0; i < N; i++) {
            temp.add(br.readLine());
        }

        String[] words = temp.toArray(new String[temp.size()]);

        Arrays.sort(words,(a,b)-> {
            if(a.length() == b.length()) {
                return a.compareTo(b);
            }
            return a.length() - b.length();
        });

        for(String word : words) {
            System.out.println(word);
        }
    }
}
