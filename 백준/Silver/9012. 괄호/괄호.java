import java.util.*;
import java.io.*;

/*
    BAEKJOON 9012번 괄호
    https://www.acmicpc.net/problem/9012
*/

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        for(int i = 0; i < N; i++){
            String s = input.next();

            System.out.println(isVPS(s) ? "YES" : "NO");
        }
    }
    public static boolean isVPS(String s){
        Deque<Character> stack = new ArrayDeque<>();

        // 괄호 하나씩 스택에 저장
        for(char c : s.toCharArray()){
            // '('인지 확인
            if(c == '('){
                stack.push(c);
            }
            // ')' 일 때 체크
            else{
                // 1. 열린 괄호가 없을 때
                if(stack.isEmpty()) return false;

                // 2. 열린 괄호가 있을 경우
                char top = stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
