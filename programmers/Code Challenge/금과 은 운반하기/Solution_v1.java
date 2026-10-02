class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 0L;
        long right = 400_000_000_000_000L;
        long mid = left + (right - left) / 2;
        
        while(left < right) {
            if (canMove(a, b, g, s, w, t, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }
        
        return mid;
    }
    
    private boolean canMove(int a, int b, int[] g, int[] s, int[] w, int[] t, long time) {
        long total = 0L;
        long gold = 0L;
        long silver = 0L;
        
        for (int i=0; i<g.length; i++) {
            long totalTime = (time + t[i]) / (t[i] * 2);
            
            total += Math.min(g[i] + s[i], totalTime * w[i]);
            gold += Math.min(g[i], totalTime * w[i]);
            silver += Math.min(s[i], totalTime * w[i]);
        }
        
        if (total >= (a + b) && gold >= a && silver >= b) return true;
        return false;
    }
}