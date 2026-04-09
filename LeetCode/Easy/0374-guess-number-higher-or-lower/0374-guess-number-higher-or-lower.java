/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int g = guess(mid);
            // n이 pick보다 크면 -1 체크
            if(g < 0){
                // -1이 나오면 end를 줄여야 함
                end = mid - 1;
            }
            // n이 pick보다 작으면 1 체크
            else if(g > 0){
                // 1이 나오면 start을 키워야 함. 
                start = mid + 1;
            }
            // n == pick이면 0 체크
            // 0이 나오면 return 정답; 
            else return mid;
        }
        return 0;
    }
}