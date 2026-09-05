class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] board = new int[n + 1][m + 1];
        
        for (int[] puddle : puddles) {
            board[puddle[1]][puddle[0]] = -1;
        }
        
        board[1][1] = 1;
        
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (board[y][x] == -1) {
                    board[y][x] = 0;
                    continue;
                }

                if (x == 1 && y == 1) continue;

                board[y][x] = (board[y-1][x] + board[y][x-1]) % MOD;
            }
        }
        
        return board[n][m];
    }
}