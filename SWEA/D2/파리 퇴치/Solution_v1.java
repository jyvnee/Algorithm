
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T;
		T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] board = new int[n][n];
			
			for (int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j=0; j<n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int num = n - m + 1;
			
			for (int i=0; i<num; i++) {
				for (int j=0; j<num; j++) {
					int count = 0;
					
					for (int r=i; r<i+m; r++) {
						for (int c=j; c<j+m; c++) {
							count += board[r][c];
						}
					}
					
					if (count > answer) {
						answer = count;
					}
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb);
	}

}
