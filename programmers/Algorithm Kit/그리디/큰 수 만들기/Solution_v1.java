import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int remaining = k;
        
        Deque<Character> dq = new ArrayDeque<>();
        dq.offer(number.charAt(0));
        
        for (int i=1; i<number.length(); i++) {
            if (remaining > 0) {
                
                while (remaining > 0 && !dq.isEmpty() && dq.peekLast() < number.charAt(i)) {
                    dq.pollLast();
                    remaining--;
                }
            }
            
            dq.offer(number.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (remaining > 0) {
            dq.pollLast();
            remaining--;
        }
        
        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst());
        }
        
        return sb.toString();
    }
}