import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int H = scanner.nextInt(); // 시간
    int M = scanner.nextInt(); // 분
    int temp;

    if (M >= 45){
        M -= 45;
      System.out.println(H + " " + M);
    }
    else{
       temp = M-45;
       M = 60+temp;
       if(H != 0) {H--;}
       else {H = 23;}
      System.out.println(H + " " + M);
    }
  }
}
