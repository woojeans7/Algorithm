import java.io.*;
import java.util.*;

public class Solution {
    public int solution(int n) {
        int count = 0;
        int sum = 0;
        int left = 1;
        int right = 1;

        while(left <= n){
            if(sum == n) {
                count++;
                sum -= left;
                left++;
            }
            else if(sum > n){
                sum -= left;
                left++;
            }
            else{
                sum += right;
                right++;
            }
        }

        return count;
    }

    public static void main(String[] args){
        Solution main = new Solution();

        System.out.println(main.solution(15));
    }
}
