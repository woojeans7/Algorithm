import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] sources = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            sources[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sources);

        int left = 0;
        int right = n - 1;
        int count = 0;
        while(left < right){
            if(sources[left] + sources[right] == m){
                count++;
                left++;
                right--;
            }
            else if(sources[left] + sources[right] < m){
                left++;
            }
            else if(sources[left] + sources[right] > m){
                right--;
            }
        }
        System.out.println(count);
    }
}
