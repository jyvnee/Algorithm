import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int count = 1;
        int remaining = calculateRemain(progresses[0], speeds[0]);
        
        for (int i=1; i<progresses.length; i++) {
            int taskRemaining = calculateRemain(progresses[i], speeds[i]);

            if (taskRemaining <= remaining) {
                count++;
            } else {
                list.add(count);
                count = 1;
                remaining = taskRemaining;
            }
        }

        list.add(count);

        int[] answer = new int[list.size()];
        
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public int calculateRemain(int progress, int speed) {
        return (100 - progress + speed - 1) / speed;
    }
}