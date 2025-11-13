import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Integer, List<String>> member = new HashMap<>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            member.putIfAbsent(age, new ArrayList<>());
            member.get(age).add(name);
        }

        StringBuilder sb = new StringBuilder();
        for(int key : member.keySet()){
            for(String name : member.get(key)){
                sb.append(key).append(" ").append(name).append("\n");
            }
        }

        System.out.println(sb);
    }
}
