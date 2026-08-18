import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] clothe: clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }
        
        int answer = 1;
        for (int value : map.values()) {
            answer *= (value + 1);
        }
            
        return answer-1;
    }
}