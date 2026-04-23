class Time implements Comparable<Time>{
    int start;
    int end;

    public Time(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o){
        if(this.end == o.end) return this.start - o.start;
        else return this.end - o.end;
    }
}
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int cnt = 0;
        List<Time> list = new ArrayList<>();
        for(int[] interval : intervals){
            Time time = new Time(interval[0], interval[1]);
            list.add(time);
        }
        Collections.sort(list);
        int et = Integer.MIN_VALUE;
        for(Time ob : list){
            if(ob.start >= et){
                cnt++;
                et = ob.end;
            }
        }
        return intervals.length - cnt;
    }
}