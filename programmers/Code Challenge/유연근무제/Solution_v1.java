class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        int answer = 0;
        
        for (int i=0; i<n; i++) {
            if (canGetPresent(schedules[i], startday, timelogs[i])) {
                answer++;
            }
        }
            
        return answer;
    }
    
    public boolean canGetPresent(int schedule, int startday, int[] timelogs) {
        int time = schedule + 10;
        if (time % 100 >= 60) {
            int hour = time / 100 + 1;
            int minute = time % 100 % 60;
            time = hour * 100 + minute;
        }
        
        for (int i=0; i<7; i++) {
            int day = (startday - 1 + i) % 7 + 1;
            if (day == 6 || day == 7) continue;
            if (timelogs[i] > time) return false;
        }
        
        return true;
    }
}