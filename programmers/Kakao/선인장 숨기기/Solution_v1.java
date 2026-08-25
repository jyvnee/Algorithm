class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[] answer = {};
        boolean[][] visited = new boolean[m-h+1][n-w+1];
        int remaining = (m-h+1) * (n-w+1);

        for (int[] pos : drops) {
            int startRow = Math.max(pos[0] - h + 1, 0);
            int endRow = Math.min(pos[0], m - h);
            int startCol = Math.max(pos[1] - w + 1, 0);
            int endCol = Math.min(pos[1], n - w);

            int firstR = -1, firstC = -1;
            for (int r = startRow; r <= endRow; r++) {
                for (int c = startCol; c <= endCol; c++) {
                    if (visited[r][c]) continue;
                    if (firstR == -1) {
                        firstR = r;
                        firstC = c;
                    }

                    visited[r][c] = true;
                    remaining--;
                }
            }
            if (remaining == 0) return new int[] {firstR, firstC};
        }

        for (int r = 0; r < visited.length; r++) {
            for (int c = 0; c < visited[0].length; c++) {
                if (!visited[r][c]) return new int[] {r, c};
            }
        }

        return answer;
    }
}
