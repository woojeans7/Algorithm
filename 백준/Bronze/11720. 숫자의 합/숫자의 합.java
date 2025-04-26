import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    String input = scanner.next();
    char[] chars = input.toCharArray();
    int sum = 0;
    for (int i = 0; i < chars.length; i++) {
      sum += chars[i] - '0';
    }
    System.out.println(sum);
  }
}
