import java.util.*;
import java.io.*;

/*
    BAEKJOON 1764번 듣보잡
    https://www.acmicpc.net/problem/1764
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0));
        }
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if(map.containsKey(name)){
                map.put(name, map.get(name) + 1);
            }
            else{
                map.put(name, 0);
            }
        }

        List<String> list = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key) == 1){
                list.add(key);
            }
        }
        System.out.println(list.size());
        list.stream().sorted().forEach(System.out::println);
    }
}
