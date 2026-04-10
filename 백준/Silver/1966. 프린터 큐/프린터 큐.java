import java.util.*;
import java.io.*;

/*
    BAEKJOON 1966번 프린터 큐
    https://www.acmicpc.net/problem/1966
*/

class Document{
    int idx;
    int priority;
    public Document(int idx, int priority){
        this.idx = idx;
        this.priority = priority;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =  Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] docs =  new int[N];
            for(int i = 0; i < N; i++){
                docs[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(find(N,M,docs));
        }
    }
    private static int find(int N, int M, int[] docs){
        int answer = 1;
        Queue<Document> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            q.offer(new Document(i, docs[i]));
        }
        while(!q.isEmpty()){
            Document temp = q.poll();
            for(Document d : q){
                if(d.priority > temp.priority){
                    q.add(temp);
                    temp = null;
                    break;
                }
            }
            if(temp != null){
                if(temp.idx == M) return answer;
                else answer++;
            }
        }
        return answer;
    }
}
