import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t < 11; t++){
            int N = Integer.parseInt(bufferedReader.readLine());

            char[][] board = new char[8][8];
            for(int i = 0; i < 8; i++){
                String line = bufferedReader.readLine();
                board[i] = line.toCharArray();
            }

            int count = 0;

            // 가로 문자 탐색
            for(int i = 0; i < 8; i++){
                for(int j = 0; j <= 8-N; j++){
                    StringBuilder temp = new StringBuilder();

                    // j부터 j+N-1까지 문자 추출
                    for(int k = 0; k < N; k++){
                        temp.append(board[i][j+k]);
                    }
                    if(isPalindrome(temp.toString())){
                        count++;
                    }
                }
            }

            // 세로 문자 탐색
            for(int i = 0; i < 8; i++){
                for(int j = 0; j <= 8-N; j++){
                    StringBuilder temp = new StringBuilder();
                    for(int k = 0; k < N; k++){
                        temp.append(board[j+k][i]);
                    }
                    if(isPalindrome(temp.toString())){
                        count++;
                    }
                }
            }
            //System.out.println(Arrays.deepToString(board));
            sb.append("#" + t).append(" " + count).append("\n");
        }
        System.out.println(sb);
    }
    // 회문 판별 함수
    private static boolean isPalindrome(String s){
        int len = s.length();
        for(int i = 0; i < len/2; i++){
            if(s.charAt(i) != s.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }
}