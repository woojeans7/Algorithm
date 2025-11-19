import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    static final String[] label = {
            "0001101",  // 0
            "0011001",  // 1
            "0010011",  // 2
            "0111101",  // 3
            "0100011",  // 4
            "0110001",  // 5
            "0101111",  // 6
            "0111011",  // 7
            "0110111",  // 8
            "0001011"   // 9
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String[] line = new String[N];
            for(int i = 0; i < N; i++){
                line[i] = br.readLine();
            }

            int answer = 0;
            boolean flag = false;

            for(int i = 0; i < N && !flag; i++){
                for(int j = 0; j <= M-56; j++){
                    String code = line[i].substring(j, j+56);

                    if(code.charAt(55) == '1' && code.contains("1")){
                        int result = check(code);
                        if(result != -1){
                            answer = result;
                            flag = true;
                            break;
                        }
                    }
                }
            }
            sb.append("#" + t).append(" ").append(answer + "\n");
        }
        System.out.println(sb);
    }
    private static int check(String code) {
        int[] password = new int[8];

        for (int i = 0; i < 8; i++) {
            String part = code.substring(i * 7, (i + 1) * 7);

            int num = -1;
            for(int j = 0; j < 10; j++){
                if(label[j].equals(part)){
                    num = j;
                    break;
                }
            }
            if(num == -1) return -1;

            password[i] = num;
        }

        int odd = 0;
        int even = 0;
        for(int i = 0; i < 8; i++){
            if(i % 2 == 0){
                odd += password[i];
            }
            else{
                even += password[i];
            }
        }
        int result = (odd * 3) + even;

        if(result % 10 == 0) return odd + even;
        else return 0;

    }
}
