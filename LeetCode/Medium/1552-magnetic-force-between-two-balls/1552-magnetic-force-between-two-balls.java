class Solution {
    public int maxDistance(int[] position, int m) {
        // 여러 개의 바구니가 position에 놓여져있음.
        // m개의 자석 공이 존재함.
        // m개의 공의 최소 거리를 서로 최대한 멀게 만드는 문제
        // 다닥다닥 붙어있지 않게, 최대한 공을 멀리 배치했을 때의 최소 간격을 구하는 문제
        int answer = 0;

        Arrays.sort(position);
        int left = 1;
        int right = position[position.length-1];
        while(left <= right){
            int mid = (left + right) / 2;
            if(count(position, mid) >= m){
                answer = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }

        return answer;
    }
    private int count(int[] position, int dist){
        int cnt = 1;
        int pos = position[0];
        for(int i = 1; i < position.length; i++){
            if(position[i] - pos >= dist){
                cnt++;
                pos = position[i];
            }
        }
        return cnt;
    }
}