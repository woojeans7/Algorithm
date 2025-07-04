class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        
        int playSec = convert(play_time);
        int advSec = convert(adv_time);
        
        int[] totalSec = new int[100 * 3600];
        for(String log : logs){
            int start = convert(log.substring(0,8));
            int end = convert(log.substring(9,17));
            
            for(int i = start; i < end; i++){
                totalSec[i] += 1;
            }
        }
        long curSum = 0;
        for(int i = 0; i < advSec; i++){
            curSum += totalSec[i];
        }

        long maxSum = curSum;
        int maxIdx = 0;
        for(int i = advSec; i < playSec; i++){
            curSum = curSum + totalSec[i] - totalSec[i-advSec];
            if(curSum > maxSum){
                maxSum = curSum;
                maxIdx = i - advSec + 1;
            }
        }
        return String.format("%02d:%02d:%02d", maxIdx/3600, maxIdx / 60%60, maxIdx % 60);
    }
    
    public int convert(String time){
        String[] nums = time.split(":");
        int hour = Integer.parseInt(nums[0]) * 3600;
        int minute = Integer.parseInt(nums[1]) * 60;
        int sec = Integer.parseInt(nums[2]);
        return hour + minute + sec;
    }
}