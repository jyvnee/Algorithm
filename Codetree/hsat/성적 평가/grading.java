import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][][] scores = new int[4][n][2];
        int[][] answer = new int[4][n];

        for (int x=0; x<3; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int y=0; y<n; y++) {
                scores[x][y][0] = Integer.parseInt(st.nextToken());
                scores[x][y][1] = y;
            }
        }

        for (int y=0; y<n; y++) {
            scores[3][y][0] = scores[0][y][0] + scores[1][y][0] + scores[2][y][0];
            scores[3][y][1] = y;
        }

        for (int x=0; x<4; x++) {
            Arrays.sort(scores[x], (a, b) -> Integer.compare(b[0], a[0]));
        }

        for (int x=0; x<4; x++) {
            int score = scores[x][0][0];
            int index = scores[x][0][1];
            int rank = 1;

            answer[x][index] = rank;

            for (int y=1; y<n; y++) {
                int curScore = scores[x][y][0];
                int curIndex = scores[x][y][1];

                if (score == curScore) {
                    answer[x][curIndex] = rank;
                } else {
                    score = curScore;
                    index = curIndex;
                    rank = y + 1;
                    answer[x][curIndex] = rank;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x=0; x<4; x++) {
            for (int y=0; y<n; y++) {
                sb.append(answer[x][y] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}