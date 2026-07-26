import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int remaining = L;

            for (int i = 0; i < N; i++) {
                int current = Integer.parseInt(st.nextToken());
                if (current != -1 && (M - current) > remaining) {
                    remaining = (M - current);
                }
            }

            if (remaining == 1) {
                sb.append("The scoreboard has been frozen with 1 minute remaining.\n");
            } else {
                sb.append("The scoreboard has been frozen with ").append(remaining).append(" minutes remaining.\n");
            }
        }

        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        pw.print(sb.toString());
        pw.flush();
        pw.close();
    }
}