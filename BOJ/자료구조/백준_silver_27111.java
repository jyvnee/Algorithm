import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        int wrong = 0;

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (b == 1) {
                if (set.contains(a)) wrong++;
                else set.add(a);
            } else {
                if (!set.contains(a)) wrong++;
                else set.remove(a);
            }
        }
        wrong += set.size();
        System.out.println(wrong);
    }
}