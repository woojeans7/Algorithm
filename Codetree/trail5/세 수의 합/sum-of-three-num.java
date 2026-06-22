import java.io.*;
import java.util.*;

public class Main {
    public long solution(long[] nums, int k) {
        int n  = nums.length;
        Arrays.sort(nums);
        long count = 0;

        for(int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while(left < right) {
                long sum = nums[i] + nums[left] + nums[right];

                if(sum == k) {
                    if(nums[left] == nums[right]) {
                        long len = right - left + 1;
                        count += len * (len - 1) / 2;
                        break;
                    }

                    long leftCount = 1;
                    long rightCount = 1;
                    while (left + leftCount < right && nums[left] == nums[(int)(left + leftCount)]) leftCount++;
                    while (right - rightCount > left && nums[right] == nums[(int)(right - rightCount)]) rightCount++;
                    count += leftCount * rightCount;
                    left += leftCount;
                    right -= rightCount;
                } else if(sum < k) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] A = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        Main main = new Main();
        System.out.println(main.solution(A, K));
    }
}