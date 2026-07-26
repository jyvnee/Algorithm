import java.io.*;
import java.util.*;

public class Main {
    static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        if (n >= 0) isPrime[0] = false;
        if (n >= 1) isPrime[1] = false;

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int q = p * p; q <= n; q += p) {
                    isPrime[q] = false;
                }
            }
        }
        return isPrime;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] isPrime = sieve(200000);

        int[][] grid = new int[2][n];
        for (int i=0; i<2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int empty = 0;
        int filled = isPrime[grid[0][0] + grid[1][0]] ? a : b;
        for (int i = 1; i < n; i++) {
            int sumV = grid[0][i] + grid[1][i];
            int scoreV = isPrime[sumV] ? a : b;
            int sumT = grid[0][i - 1] + grid[0][i];
            int scoreT = isPrime[sumT] ? a : b;
            int sumB = grid[1][i - 1] + grid[1][i];
            int scoreB = isPrime[sumB] ? a : b;

            int newFilled = Math.max(filled + scoreV, empty + scoreT + scoreB);
            empty = filled;
            filled = newFilled;
        }

        System.out.println(filled);
    }
}