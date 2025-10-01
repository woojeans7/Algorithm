import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      String result = "";
      String word = st.nextToken();
      for(char ch : word.toCharArray()) {
          if(Character.isLowerCase(ch)) {
              result += Character.toUpperCase(ch);
          }
          else {
              result += Character.toLowerCase(ch);
          }
      }

      System.out.println(result);
	}
}
