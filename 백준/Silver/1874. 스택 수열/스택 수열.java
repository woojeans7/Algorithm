import java.util.*;
import java.io.*;

/*
    BAEKJOON 1874번 스택 수열
    https://www.acmicpc.net/problem/1874
*/

public class Main {

  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      StringBuffer bf = new StringBuffer();

      int n = Integer.parseInt(st.nextToken());
      int[] array = new int[n];
      for (int i = 0; i < n; i++) {
          st = new StringTokenizer(br.readLine());
          array[i] = Integer.parseInt(st.nextToken());
      }

      ArrayDeque<Integer> stack = new ArrayDeque<>();
      boolean result = true;
      int num = 1;
      for(int k : array) {
          int temp = k;
          if(temp >= num) {
              while(temp >= num){
                  stack.push(num++);
                  bf.append("+\n");
              }
              stack.pop();
              bf.append("-\n");
          }
          else{
              int m = stack.pop();

              if(m > temp){
                  System.out.println("NO");
                  result = false;
                  break;
              }
              else{
                  bf.append("-\n");
              }
          }
      }
      if(result) System.out.println(bf.toString());
	}
}
