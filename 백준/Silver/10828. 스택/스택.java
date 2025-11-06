import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }
            else if(command.equals("pop")){
                if(!stack.isEmpty()) sb.append(stack.pop()).append("\n");
                else sb.append("-1").append("\n");
            }
            else if(command.equals("size")){
                sb.append(stack.size()).append("\n");
            }
            else if(command.equals("top")){
                if(!stack.isEmpty()) sb.append(stack.peek()).append("\n");
                else sb.append("-1").append("\n");
            }
            else if(command.equals("empty")){
                int check = stack.isEmpty() ? 1 : 0;
                sb.append(check).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
