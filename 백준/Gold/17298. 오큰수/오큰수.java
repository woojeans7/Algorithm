import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int N = Integer.parseInt(st.nextToken());
      int[] arr = new int[N];
      int[] answer = new int[N];

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
          arr[i] = Integer.parseInt(st.nextToken());
      }

      ArrayDeque<Integer> stack = new ArrayDeque<>();
      stack.push(0);
      for (int i = 1; i < N; i++) {
          while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
              answer[stack.pop()] = arr[i];
          }
          stack.push(i);
      }
      while (!stack.isEmpty()) {
          answer[stack.pop()] = -1;
      }

      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      for(int i = 0; i < N; i++){
          bw.write(answer[i] + " ");
      }
      bw.flush();
	}
}
