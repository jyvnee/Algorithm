import java.util.*;

class Solution {
    private int n;
    
    public int solution(int n, int[][] wires) {
        this.n = n;
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i=0; i<wires.length; i++) {
            map.computeIfAbsent(wires[i][0], k -> new HashSet<Integer>()).add(wires[i][1]);
            map.computeIfAbsent(wires[i][1], k -> new HashSet<Integer>()).add(wires[i][0]);
        }
        
        int answer = Integer.MAX_VALUE;
        
        for (int i=0; i<wires.length; i++) {
            answer = Math.min(answer, checkDiff(map, wires[i]));
        }
        
        return answer;
    }
    
    private int checkDiff(Map<Integer, Set<Integer>> map, int[] deletedWire) {
        boolean[] visited = new boolean[n+1];
        
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(1);
        visited[1] = true;
        int count = 1;
        
        while (!dq.isEmpty()) {
            int node = dq.poll();
            Set<Integer> wiredNodes = map.get(node);
            
            for (int wiredNode : wiredNodes) {
                if (isDeletedWired(node, wiredNode, deletedWire)) continue;
                if (visited[wiredNode]) continue;
                
                visited[wiredNode] = true;
                dq.offer(wiredNode);
                count++;
            }
        }
        
        return Math.abs(count - (n - count));
    }
    
    private boolean isDeletedWired(int nodeA, int nodeB, int[] deletedWire) {
        if (nodeA == deletedWire[0] && nodeB == deletedWire[1]) return true;
        if (nodeA == deletedWire[1] && nodeB == deletedWire[0]) return true;
        return false;
    }
}