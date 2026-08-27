
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T;
		T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			br.readLine();
			int[] count = new int[101];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i=0; i<1000; i++) {
				int score = Integer.parseInt(st.nextToken());
				count[score]++;
			}
			
			int answer = 0;
			int maxCount = 0;
			
			for (int i=0; i<=100; i++) {
				if (count[i] >= maxCount) {
					maxCount = count[i];
					answer = i;
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb);
	}

}
