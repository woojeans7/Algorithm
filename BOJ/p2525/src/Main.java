import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
      int h = scanner.nextInt();
      int m = scanner.nextInt();
      int t = scanner.nextInt();

      if (m+t >= 60) {
            m = 60 - (m+t);
            if (m == 60) {
              m = 0;
              h++;
            }
            else if (m <){

            }
            h++;

          System.out.println(h + " " + m);
      }
      else {
        m += t;
        System.out.println(h + " " + m);
      }

  }
}
