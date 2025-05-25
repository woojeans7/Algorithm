import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<String> timeCheck = new ArrayList<>();
        // 차 번호와 입출 시간 내역 저장
        Map<String, List<String>> cars = new HashMap<>();

        for(int i = 0; i < records.length; i++){
            // 분리 후 임시로 저장할 배열 
            String[] temp = records[i].split(" ");
            cars.putIfAbsent(temp[1], new ArrayList<>());
            cars.get(temp[1]).add(temp[0]);
        }
        // System.out.println(cars);

        // 트리맵으로 정렬 
        Map<String, Integer> resultMap = new TreeMap<>();
        for (String car : cars.keySet()) {
            List<String> times = cars.get(car);

            // 마지막 OUT이 없으면 23:59 추가
            if (times.size() % 2 == 1) {
                times.add("23:59");
            }
            
            // 요금 계산
            int totalTime = 0;
            for (int i = 0; i < times.size(); i += 2) {
                totalTime += minCalculator(times.get(i), times.get(i + 1));
            }

            int totalFee = feeCalc(fees, totalTime);
            resultMap.put(car, totalFee);
        }

        // 요금을 오름차순으로 배열로 반환
        int[] answer = new int[resultMap.size()];
        int idx = 0;
        for (int fee : resultMap.values()) {
            answer[idx++] = fee;
        }
        return answer;
    }
    // 시간 계산
    public int minCalculator(String in, String out){
        String[] s1 = in.split(":");
        String[] s2 = out.split(":");

        int outTime = Integer.parseInt(s2[0]) * 60 + Integer.parseInt(s2[1]);
        int inTime = Integer.parseInt(s1[0]) * 60 + Integer.parseInt(s1[1]);

        return (outTime - inTime);
    }
    // 요금 계산
    public int feeCalc(int[] fees, int time){
        int defaultTime = fees[0], defaultFee = fees[1], partTime = fees[2], partFee = fees[3];

        if(time <= defaultTime){
            return defaultFee;
        }
        int total = defaultFee + (int)Math.ceil((time - defaultTime) / (double)partTime) * partFee;

        return total;            
    }
}