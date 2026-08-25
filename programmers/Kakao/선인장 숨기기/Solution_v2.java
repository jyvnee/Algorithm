class Solution {
    int[] colParent;
    int[] rowParent;
    int C;

    int findCol(int r, int c) {
        int base = r * (C + 1);
        while (colParent[base + c] != c) {
            colParent[base + c] = colParent[base + colParent[base + c]];
            c = colParent[base + c];
        }
        return c;
    }

    int findRow(int r) {
        while(rowParent[r] != r) {
            rowParent[r] = rowParent[rowParent[r]];
            r = rowParent[r];
        }
        return r;
    }

    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int R = m - h + 1;
        C = n - w + 1;

        boolean[][] visited = new boolean[R][C];

        colParent = new int[R * (C + 1)];
        for (int r = 0; r < R; r++) {
            int base = r * (C + 1);
            for (int c = 0; c <= C; c++) {
                colParent[base + c] = c;
            }
        }

        rowParent = new int[R + 1];
        for (int r = 0; r <= R; r++) {
            rowParent[r] = r;
        }

        int remaining = R * C;

        for (int[] pos : drops) {
            int startRow = Math.max(pos[0] - h + 1, 0);
            int endRow = Math.min(pos[0], m - h);
            int startCol = Math.max(pos[1] - w + 1, 0);
            int endCol = Math.min(pos[1], n - w);

            int firstR = -1, firstC = -1;

            int r = findRow(startRow);
            while (r <= endRow) {
                int c = findCol(r, startCol);
                while (c <= endCol) {
                    if (firstR == -1) {
                        firstR = r;
                        firstC = c;
                    }
                    visited[r][c] = true;
                    remaining--;
                    colParent[r * (C + 1) + c] = c + 1;
                    c = findCol(r, c + 1);
                }

                if (findCol(r, 0) == C) {
                    rowParent[r] = r + 1;
                }
                r = findRow(r + 1);
            }

            if (remaining == 0) return new int[] {firstR, firstC};
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (!visited[r][c]) return new int[] {r, c};
            }
        }

        return new int[] {};
    }
}
