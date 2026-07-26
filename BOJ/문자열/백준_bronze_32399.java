import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        int ans;
        if ("(1)".equals(s)) {
            ans = 0;
        } else if (")1(".equals(s)) {
            ans = 2;
        } else {
            ans = 1;
        }

        System.out.println(ans);
        br.close();
    }
}