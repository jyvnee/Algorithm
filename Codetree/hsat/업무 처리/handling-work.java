import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int leafStaffCount = (int) Math.pow(2, h);
        int[][] tasks = new int[leafStaffCount][k];

        for (int i=0; i<leafStaffCount; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<k; j++) {
                tasks[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int height = h-1;
        int taskCount = k;
        int time = 2;

        for (int i=height; i>=0; i--) {
            int newStaffCount = (int) Math.pow(2, i);
            taskCount *= 2;
            int[][] newStaffTasks = new int[newStaffCount][taskCount];

            for (int j=0; j<newStaffCount; j++) {
                newStaffTasks[j] = getTasks(tasks[j*2], tasks[j*2+1], time);
            }

            time++;
            tasks = newStaffTasks;
        }

        int answer = 0;
        int processedTaskCount = Math.min(Math.max(r-h, 0), tasks[0].length);

        for (int i=0; i<processedTaskCount; i++) {
            answer += tasks[0][i];
        }

        System.out.print(answer);
    }

    public static int[] getTasks(int[] leftChildTasks, int[] rightChildTasks, int time) {
        int childTaskCount = leftChildTasks.length;
        int[] myTasks = new int[childTaskCount * 2];
        
        if (time % 2 == 0) {
            // 오른쪽부터
            for (int i=0; i<childTaskCount; i++) {
                myTasks[i*2] = rightChildTasks[i];
                myTasks[i*2+1] = leftChildTasks[i];
            }
        } else {
            // 왼쪽부터
            for (int i=0; i<childTaskCount; i++) {
                myTasks[i*2] = leftChildTasks[i];
                myTasks[i*2+1] = rightChildTasks[i];
            }
        }

        return myTasks;
    }
}