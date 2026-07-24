import java.util.*;
import java.io.*;

public class Main {

    static class Car {
        int time;   // 차량이 도로에 도착하는 시각
        int index;  // 차량의 입력 순서

        Car(int time, int index) {
            this.time = time;
            this.index = index;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // A: 0, B: 1, C: 2, D: 3
        Deque<Car>[] roads = new ArrayDeque[4];
        for (int i=0; i<4; i++) {
            roads[i] = new ArrayDeque<>();
        }

        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        int currentTime = 0;

        for (int i=0 ; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int road = st.nextToken().charAt(0) - 'A';

            roads[road].offerLast(new Car(time, i));

            if (i == 0) {
                currentTime = time;
            }
        }

        int remaining = n;

        while (remaining > 0) {

            // 현재 시각에 실제로 교차로에 대기 중인 도로
            boolean[] waiting = new boolean[4];
            int waitingRoadCount = 0;

            for (int i=0; i<4; i++) {
                if (!roads[i].isEmpty() && roads[i].peekFirst().time <= currentTime) {
                    waiting[i] = true;
                    waitingRoadCount++;
                }
            }

            // 교착 상태
            if (waitingRoadCount == 4) {
                break;
            }

            // 현재 기다리는 차가 없다면 다음 차량 도착 시각으로 점프
            if (waitingRoadCount == 0) {
                int nextTime = Integer.MAX_VALUE;

                for (int i=0; i<4; i++) {
                    if (!roads[i].isEmpty()) {
                        nextTime = Math.min(nextTime, roads[i].peekFirst().time);
                    }
                }

                currentTime = nextTime;
                continue;
            }

            // 현재 상태를 기준으로 통과 가능 여부를 먼저 계산
            boolean[] canPass = new boolean[4];
            for (int i=0; i<4; i++) {
                int rightRoad = (i + 3) % 4;
                canPass[i] = waiting[i] && !waiting[rightRoad];
            }

            // 통과 가능한 차량을 동시에 처리
            for (int i=0; i<4; i++) {
                if (canPass[i]) {
                    Car car = roads[i].pollFirst();
                    answer[car.index] = currentTime;
                    remaining--;
                }
            }
            
            currentTime++;
        }

        StringBuilder sb = new StringBuilder();
        for (int value : answer) {
            sb.append(value).append('\n');
        }
        System.out.print(sb);
    }
}