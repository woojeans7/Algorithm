import java.util.*;

/*
    BAEKJOON 1715번 카드 정렬하기
    https://www.acmicpc.net/problem/1715
*/

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            int data =  sc.nextInt();
            pq.add(data);
        }

        int count = 0;
        int sum = 0;
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();

            sum = a + b;
            count += sum;
            pq.offer(sum);
        }

        System.out.println(count);
    }
}
