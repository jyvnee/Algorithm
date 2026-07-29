import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = new HashMap<>();
        
        for (String p : participant) {
            participantMap.put(p, participantMap.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            participantMap.put(c, participantMap.getOrDefault(c, 0) - 1);
        }
        
        for (String p : participantMap.keySet()) {
            int count = participantMap.get(p);
            if (count > 0) {
                return p;
            }
        }
        
        return "";
    }
}