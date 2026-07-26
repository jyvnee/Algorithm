import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int answer = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] run = new int[2];
            int[] trick = new int[5];

            run[0] = Integer.parseInt(st.nextToken());
            run[1] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 5; j++) {
                trick[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(run);
            Arrays.sort(trick);

            int bestRun = run[1];
            int bestTricks = trick[3] + trick[4];
            int total = bestRun + bestTricks;

            if (total > answer) {
                answer = total;
            }
        }
        System.out.println(answer);
        br.close();
    }
}