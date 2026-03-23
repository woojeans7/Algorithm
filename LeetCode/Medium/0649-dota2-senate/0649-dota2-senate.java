class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') rQueue.offer(i);
            else dQueue.offer(i);
        }

        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int r = rQueue.poll();
            int d = dQueue.poll();

            // 인덱스가 작은 쪽이 먼저 행동 → 상대를 ban
            // 살아남은 의원은 다음 라운드에 참여 (index + n)
            if (r < d) {
                rQueue.offer(r + n);
            } else {
                dQueue.offer(d + n);
            }
        }

        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }
}
