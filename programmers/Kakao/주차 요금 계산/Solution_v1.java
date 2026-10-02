import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, int[]> car = new TreeMap<>();
        
        for (String r : records) {
            String[] str = r.split(" ");
            
            if (car.containsKey(str[1])) {
                int[] value = car.get(str[1]);
                
                if (str[2].equals("IN")) {
                    value[1] = timeToInt(str[0]);
                } else {
                    value[0] += calculateMinute(value[1], timeToInt(str[0]));
                    value[1] = -1;
                }
            } else {
                car.put(str[1], new int[] {0, timeToInt(str[0])});
            }
        }
        int[] answer = new int[car.size()];
        
        int index = 0;
        
        for (String k : car.keySet()) {
            int[] value = car.get(k);
            
            if (value[1] != -1) {
                value[0] += calculateMinute(value[1], 2359);
                value[1] = 0;
            }
            
            answer[index] = calculateFee(value[0], fees[0], fees[1], fees[2], fees[3]);
            index++;
        }
        
        return answer;
    }
    
    private int timeToInt(String time) {
        return Integer.parseInt(time.replace(":", ""));
    }
    
    private int calculateMinute(int start, int end) {
        int startHour = start / 100;
        int startMinute = start % 100;
        int endHour = end / 100;
        int endMinute = end % 100;
        
        return (endHour - startHour) * 60 + (endMinute - startMinute);
    }
    
    private int calculateFee(int minute, int basicMinute, int basicFee, int unitMinute, int unitFee) {
        if (minute <= basicMinute) return basicFee;
        
        int additionalFee = (int) Math.ceil((float)(minute - basicMinute) / unitMinute);
        
        return basicFee + additionalFee * unitFee;
    }
}