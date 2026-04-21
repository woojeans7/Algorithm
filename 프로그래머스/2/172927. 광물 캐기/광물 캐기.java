import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int[][] hp = {
            {1, 1, 1},
            {5, 1, 1},
            {25, 5, 1}
        };
        int dia = picks[0];
        int iron = picks[1];
        int stone = picks[2];
        
        int groupCount = (minerals.length + 4) / 5;
        int totalPicks = dia + iron + stone;
        int validGroup = Math.min(totalPicks, groupCount); // 실제로 캘 수 있는 그룹 수
        
        int[][] weight = new int[validGroup][2];
        
        for (int i = 0; i < validGroup * 5 && i < minerals.length; i++) {
            int groupIdx = i / 5;
            weight[groupIdx][1] = groupIdx;
            if (minerals[i].equals("diamond")) weight[groupIdx][0] += 25;
            else if (minerals[i].equals("iron")) weight[groupIdx][0] += 5;
            else weight[groupIdx][0] += 1;
        }
        
        Arrays.sort(weight, (a, b) -> b[0] - a[0]);
        
        for (int g = 0; g < validGroup; g++) { 
            int pickIdx;
            if (dia > 0)       { dia--;   pickIdx = 0; }
            else if (iron > 0) { iron--;  pickIdx = 1; }
            else if (stone > 0){ stone--; pickIdx = 2; }
            else break;
            
            int originalGroup = weight[g][1];
            int start = originalGroup * 5;
            int end = Math.min(start + 5, minerals.length);
            
            for (int idx = start; idx < end; idx++) {
                int mineralIdx;
                if (minerals[idx].equals("diamond")) mineralIdx = 0;
                else if (minerals[idx].equals("iron")) mineralIdx = 1;
                else mineralIdx = 2;
                answer += hp[pickIdx][mineralIdx];
            }
        }
        return answer;
    }
}