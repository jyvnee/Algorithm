class Solution {
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        return explore(k, visited, dungeons);
    }
    
    private int explore(int fatigue, boolean[] visited, int[][] dungeons) {
        int best = 0;
        
        for (int i=0; i<dungeons.length; i++) {
            if (visited[i] || fatigue < dungeons[i][0]) continue;
            
            visited[i] = true;
            best = Math.max(best, 1 + explore(fatigue - dungeons[i][1], visited, dungeons));            
            visited[i] = false;
        }
        
        return best;
    }
}