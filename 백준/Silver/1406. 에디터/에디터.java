import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        String line = br.readLine();
        for(char c : line.toCharArray()) {
            left.push(c);
        }

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String command = br.readLine();
            char cmd = command.charAt(0);
            if(cmd == 'L'){
                if(left.isEmpty()) continue;
                char tmp = left.pop();
                right.push(tmp);
            }
            else if(cmd == 'D'){
                if(right.isEmpty()) continue;
                char tmp = right.pop();
                left.push(tmp);
            }

            else if(cmd == 'B'){
                if(left.isEmpty()) continue;
                left.remove();
            }

            else if(cmd == 'P'){
                char newChar = command.charAt(2);
                left.push(newChar);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!left.isEmpty()){
            right.push(left.pop());
        }
        while(!right.isEmpty()){
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}
