import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nA; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nB; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> result = new ArrayList<>();

        for (int num : setA) {
            if (!setB.contains(num)) {
                result.add(num);
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        if (!result.isEmpty()) {
            for (int num : result) {
                System.out.print(num + " ");
            }
        }
    }
}