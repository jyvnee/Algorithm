import java.util.*;

class Solution {
    public int solution(int[][] game_board, int[][] table) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int r=0; r<table.length; r++) {
            for (int c=0; c<table[0].length; c++) {
                if (table[r][c] == 1) {
                    String key = extractShape(r, c, table, 1);
                    map.put(key, map.computeIfAbsent(key, k -> 0) + 1);
                }
            }
        }
        
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
        
        int answer = 0;
        
        for (int r=0; r<game_board.length; r++) {
            for (int c=0; c<game_board[0].length; c++) {
                if (game_board[r][c] == 0) {
                    String key = extractShape(r, c, game_board, 0);
                    
                    if (!map.containsKey(key)) continue;
                    if (map.get(key) <= 0) continue;
                    
                    map.put(key, map.get(key) - 1);
                    answer += countCell(key);
                }
            }
        }
        
        return answer;
    }
    
    private int countCell(String key) {
        System.out.println(key);
        String[] str = key.split(";");
        return str.length;
    }
    
    private String extractShape(int r, int c, int[][] board, int target) {
        int filled = (target == 0) ? 1 : 0;
        
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {r, c});
        
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        
        List<int[]> positions = new ArrayList<>();
        positions.add(new int[] {r, c});
        
        board[r][c] = filled;
        
        while (!que.isEmpty()) {
            int[] pos = que.poll();
            
            for (int i=0; i<4; i++) {
                int nr = pos[0] + dr[i];
                int nc = pos[1] + dc[i];
                
                if (nr<0 || nr>=board.length || nc<0 || nc>=board[0].length) continue;
                if (board[nr][nc] != target) continue;
                
                positions.add(new int[] {nr, nc});
                board[nr][nc] = filled;
                que.offer(new int[] {nr, nc});
            }
        }
        
        normalize(positions);
        
        positions.sort((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        
        return rotate(positions, toKey(positions));
    }
    
    private String toKey(List<int[]> positions) {
        StringBuilder sb = new StringBuilder();
        for (int[] pos : positions) {
            sb.append(pos[0]).append(',').append(pos[1]).append(';');
        }
        return sb.toString();
    }
    
    private void normalize(List<int[]> positions) {
        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        
        for (int[] pos : positions) {
            minRow = Math.min(minRow, pos[0]);
            minCol = Math.min(minCol, pos[1]);
        }
        
        for (int[] pos : positions) {
            pos[0] -= minRow;
            pos[1] -= minCol;
        }
    }
    
    private String rotate(List<int[]> positions, String original) {
        String[] keys = new String[4];
        keys[0] = original;
        List<int[]> shape = positions;
        
        for (int i=1; i<4; i++) {
            List<int[]> temp = new ArrayList<>();
            
            for (int[] pos : shape) {
                temp.add(new int[] {pos[1], -pos[0]});
            }
            
            normalize(temp);
            
            temp.sort((a, b) -> {
                if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            });
            
            keys[i] = toKey(temp);
            
            shape = temp;
        }
        
        Arrays.sort(keys);
        
        return keys[0];
    }
}