import java.util.*;
import java.io.*;

/*
    BAEKJOON 1744번 수 묶기
    https://www.acmicpc.net/problem/1744
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        int zero = 0;
        int one = 0;

        for (int i = 0; i < n; i++) {
            int num =  Integer.parseInt(br.readLine());
            if(num == 0) zero++;
            else if(num == 1) one++;
            else if(num < 0){
                minus.add(num);
            }
            else{
                plus.add(num);
            }
        }
        int sum = 0;
        // 1. 음수뽑기
        while(minus.size() > 1){
            int a = minus.remove();
            int b = minus.remove();
            int multiple = a * b;
            sum += multiple;
        }
        // 남은 값 처리
        if(!minus.isEmpty()){
            if(zero == 0){
                sum += minus.remove();
            }
        }

        // 2.양수뽑기
        while(plus.size() > 1){
            int a = plus.remove();
            int b = plus.remove();
            int multiple = a * b;
            sum += multiple;
        }
        // 남은 값 처리
        if(!plus.isEmpty()){
            sum += plus.remove();
        }
        
        // 3. 1값 처리
        sum += one;

        System.out.println(sum);

    }
}
