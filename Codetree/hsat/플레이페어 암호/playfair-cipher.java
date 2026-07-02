import java.io.*;
import java.util.*;

public class Main {
    public String solution(String message, String key) {
        // 1. 표 만들기
        Set<Character> used =  new LinkedHashSet<>();
        String[][] playfair = new String[5][5];

        // 해시셋에 순서 저장해서 채우기
        for(char c: key.toCharArray()) {
            used.add(c);
        }

        int i = 0, j = 0;
        for(char c : used){
            playfair[i][j++] = String.valueOf(c);
            if(j == 5){
                j = 0;
                i++;
            }
        }
        // 나머지 알파벳 순서대로 채우기
        for(char c = 'A'; c <= 'Z'; c++){
            if(c == 'J') continue;
            if(!used.contains(c)){
                playfair[i][j++] = String.valueOf(c);
                if(j == 5){
                    j = 0;
                    i++;
                }
            }
        }

        //System.out.println(Arrays.deepToString(playfair));

        // 2. 메시지 쪼개고 쪼갠 메시지를 X 넣어 완성하기
        StringBuilder sb = new StringBuilder();
        int k = 0;
        while(k < message.length()){
            char first = message.charAt(k);
            sb.append(first);

            if(k + 1 < message.length()){
                char second = message.charAt(k + 1);
                if(first == second){
                    if(first == 'X') sb.append('Q');
                    else sb.append('X');
                    k++;
                }
                else{
                    sb.append(second);
                    k += 2;
                }
            }
            else{
                k++;
            }
        }
        if(sb.length() % 2 != 0) sb.append('X');

        message = sb.toString();

        // 4. 글자 암호화하기
        sb = new StringBuilder();
        for(k = 0; k < message.length(); k += 2){
            String pairs = message.substring(k, k + 2);
            char first = pairs.charAt(0);
            char second = pairs.charAt(1);

            int[] pos1 = findPosition(playfair, first);
            int[] pos2 = findPosition(playfair, second);

            int r1 = pos1[0], r2 = pos2[0];
            int c1 = pos1[1], c2 = pos2[1];

            if(r1 == r2){
                c1 = (c1 + 1) % 5;
                c2 = (c2 + 1) % 5;

                sb.append(playfair[r1][c1]).append(playfair[r2][c2]);
            }
            else if(c1 == c2){
                r1 = (r1 + 1) % 5;
                r2 = (r2 + 1) % 5;

                sb.append(playfair[r1][c1]).append(playfair[r2][c2]);
            }
            else{
                sb.append(playfair[r1][c2]).append(playfair[r2][c1]);
            }
        }

        return sb.toString();
    }
    // 글자 위치 찾기
    private int[] findPosition(String[][] playfair, char c){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(playfair[i][j].equals(String.valueOf(c))){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String K = br.readLine();

        Main main = new Main();
        System.out.println(main.solution(S, K));
    }
}
