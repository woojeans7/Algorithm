class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // 아이들한테 내 남은 사탕을 줬을 때, 그 아이가 가장 많은 사탕을 가지는 지 확인
        // 가장 많이 가진 사탕의 개수를 저장
        int max = 0;
        for(int candy : candies){
            max = Math.max(candy, max);
        }

        List<Boolean> answer = new ArrayList<>();

        // 반복문으로 하나씩 더했을 때 가장 많은 사탕보다 크면 true, 아니면 false를 반환
        for(int candy : candies){
            int nowCandy = candy + extraCandies;
            answer.add(nowCandy >= max ? true : false);
        }

        return answer;
    }
}