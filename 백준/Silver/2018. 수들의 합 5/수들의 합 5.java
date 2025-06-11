import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    int start = 1;
    int end = 1;
    int sum = 0;
    int count = 1;

    while(end != N){
      for(int i = start; i <= end; i++){
        sum += i;
      }
      if(sum > N){
        sum -= start;
        start++;
      }
      else if(sum < N){
        end++;
      }
      else{
        count++;
        sum -= start;
        start++;
      }
      sum = 0;
    }

    System.out.println(count);
  }
}
