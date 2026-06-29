import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {


        // 붕대를 감는다면, 1초 당 체력 +x
        // t초 연속: 시간을 +1초씩 -> t초가 되었다. -> 체력 + y
        // 만약 현재 체력 >= 최대 체력
        // 1) 더할 건 더해주고, 최대 체력만큼 깎아버리는 방법
        // 2) 최대 체력 안 넘었어? 그럼 더해줄게

        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        int maxHp = health;

        int attackIdx = 0;
        int lastTime = attacks[attacks.length - 1][0];
        int count = 0;

        for(int i = 1; i <= lastTime; i++){

            // 공격 당하는지 체크
            if(attacks[attackIdx][0] == i){
                health -= attacks[attackIdx][1];
                attackIdx++;
                count = 0;
            }
            // 공격 안당하면
            else {
                health += x; // 1초당 회복
                count++;  // 연속 카운트
                if(count == t){
                    health += y;
                    count = 0;
                }
            }

            // 최대 체력 넘으면
            if(health > maxHp) health = maxHp;

            // 사망했으면
            if(health <= 0) return -1;
        }


        return health;
    }
}