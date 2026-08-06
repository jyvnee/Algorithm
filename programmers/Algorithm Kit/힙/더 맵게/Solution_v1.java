import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        
        for (int s : scoville) {
            pq.offer(s);
        }
        
        while (pq.peek() < K && pq.size() > 0) {
            int first = pq.poll();
            
            if (pq.isEmpty()) return -1;
            
            int second = pq.poll();
            pq.offer(first + (second * 2));
            answer++;
        }
        
        return answer;
    }
}