import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] board = new int[102][102];
        
        for (int i=0; i<rectangle.length; i++) {
            int startX = rectangle[i][0] * 2;
            int startY = rectangle[i][1] * 2;
            int endX = rectangle[i][2] * 2;
            int endY = rectangle[i][3] * 2;
            
            for (int y = startY; y <= endY; y++) {
                for (int x = startX; x <= endX; x++) {
                    board[y][x] = 2;
                }
            }
        }
        
        for (int r=1; r<=100; r++) {
            for (int c=1; c<=100; c++) {
                boolean nextZero = false;
                boolean nextTwo = false;
                
                int[] dirX = {-1, 0, 1, 1, 1, 0, -1, -1};
                int[] dirY = {1, 1, 1, 0, -1, -1, -1, 0};
                
                for (int i=0; i<8; i++) {
                    if (board[r + dirY[i]][c + dirX[i]] == 0) {
                        nextZero = true;
                    }
                    if (board[r + dirY[i]][c + dirX[i]] == 2) {
                        nextTwo = true;
                    }
                }
                
                if (board[r][c] == 2 && nextZero && nextTwo) {
                    board[r][c] = 1;
                }
            }
        }
        
        boolean[][] visited = new boolean[102][102];
        visited[characterY*2][characterX*2] = true;
        
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {characterX*2, characterY*2, 0});
        
        while(!dq.isEmpty()) {
            int[] pos = dq.poll();
            
            if (pos[0] == itemX*2 && pos[1] == itemY*2) {
                return pos[2]/2;
            }
            
            int[] dirX = {0, 1, 0, -1};
            int[] dirY = {1, 0, -1, 0};
            
            for (int i=0; i<4; i++) {
                int nextX = pos[0] + dirX[i];
                int nextY = pos[1] + dirY[i];
                
                if (board[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                    dq.offer(new int[] {nextX, nextY, pos[2] + 1});
                    visited[nextY][nextX] = true;
                }
            }
        }
        
        return 0;
    }

}