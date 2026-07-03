import java.io.*;
import java.util.*;

public class Main {
    public int[] solution(int[] t, int[] w) {
        int n = t.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1); // 교착 차량은 -1 유지

        Queue<Integer>[] cars = new Queue[4];
        for(int i = 0; i < 4; i++) cars[i] = new LinkedList<>();

        int time = -1;

        for(int i = 0; i <= n; i++) {
            int nextTime = (i < n) ? t[i] : (int)2e9; // 센티넬

            // 다음 이벤트 전까지 처리
            while(time < nextTime &&
                    (!cars[0].isEmpty() || !cars[1].isEmpty() ||
                            !cars[2].isEmpty() || !cars[3].isEmpty())) {

                boolean[] canPass = new boolean[4];
                boolean any = false;
                for(int d = 0; d < 4; d++) {
                    if(!cars[d].isEmpty() && cars[(d+3)%4].isEmpty()) {
                        canPass[d] = true;
                        any = true;
                    }
                }
                if(!any) break; // 교착 → break, 해당 차량은 -1 유지

                for(int d = 0; d < 4; d++) {
                    if(canPass[d]) answer[cars[d].poll()] = time;
                }
                time++;
            }

            // 다음 이벤트 시각으로 점프 + 차량 진입
            if(i < n) {
                time = t[i];
                cars[w[i]].add(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Main main = new Main();
        int[] T = new int[N];
        int[] W = new int[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            char c =  st.nextToken().charAt(0);
            switch(c){
                case 'A':
                    W[i] = 0;
                    break;
                case 'B':
                    W[i] = 1;
                    break;
                case 'C':
                    W[i] = 2;
                    break;
                default: W[i] = 3;
            }
        }

        int[] answer = main.solution(T, W);
        for(int i = 0; i < N; i++){
            System.out.println(answer[i]);
        }
    }
}