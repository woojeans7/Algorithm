import java.util.*;
import java.io.*;

/*
    BAEKJOON 1931번 회의실 배정
    https://www.acmicpc.net/problem/1931
*/

public class Main {
    public static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.end == o.end) return Integer.compare(this.start, o.start);
            return this.end - o.end;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Meeting> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.offer(new Meeting(start, end));
        }

        int count = 0;
        int curEnd = 0; // 초기값
        for(int i = 0; i < N; i++){
            Meeting next = pq.poll();
            // 현재 회의 종료시간이 다음 회의 시작시간보다 작거나 같을 경우 새 회의 시작
            if(next.start >= curEnd){
                count++;
                curEnd = next.end; // 현재 끝나는 시간 업데이트
            }
        }

        System.out.println(count);
    }
}
