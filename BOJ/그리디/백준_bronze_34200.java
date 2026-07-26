import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int current = 0;
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            int next = Integer.parseInt(st.nextToken());
            int distance = next - current;
            if (distance == 0) {
                System.out.println(-1);
                br.close();
                return;
            } else {
                count += (distance / 2 + 1);
            }
            current = next + 1;
        }
        System.out.println(count);
        br.close();
    }
}