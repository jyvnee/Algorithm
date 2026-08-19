import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int networkCount = 0;
        
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                bfs(i, computers, visited, n);
                networkCount++;
            }
        }
        
        return networkCount;
    }
    
    private void bfs(int start, int[][] computers, boolean[] visited, int n) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next=0; next<n; next++) {
                if (!visited[next] && computers[current][next] == 1) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}