import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int current = arr[0];
        list.add(current);
        
        for (int i=1; i<arr.length; i++) {
            if (current == arr[i]) continue;
            
            current = arr[i];
            list.add(current);
        }
        
        int[] answer = new int[list.size()];
            
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}