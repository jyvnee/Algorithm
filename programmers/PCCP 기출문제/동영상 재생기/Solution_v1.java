class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int[] videoLen = {
            Integer.parseInt(video_len.substring(0,2)),
            Integer.parseInt(video_len.substring(3))
        };
        int[] openingStart = {
            Integer.parseInt(op_start.substring(0, 2)),
            Integer.parseInt(op_start.substring(3))
        };
        int[] openingEnd = {
            Integer.parseInt(op_end.substring(0, 2)),
            Integer.parseInt(op_end.substring(3))
        };
        int[] current = {
            Integer.parseInt(pos.substring(0, 2)),
            Integer.parseInt(pos.substring(3))
        };
        
        for (String cmd : commands) {
            if (isOpening(openingStart, openingEnd, current)) {
                current[0] = openingEnd[0];
                current[1] = openingEnd[1];
            }
            
            switch (cmd) {
                    case "prev" -> movePrev(videoLen, current);
                    case "next" ->  moveNext(videoLen, current);
            }
            
            if (isOpening(openingStart, openingEnd, current)) {
                current[0] = openingEnd[0];
                current[1] = openingEnd[1];
            }
        }
        
        return String.format("%02d:%02d", current[0], current[1]);
    }
    
    public void moveNext(int[] videoLen, int[] current) {
        current[1] += 10;
        if (current[1] >= 60) {
            current[0] += 1;
            current[1] %= 60;
        }
        
        if (compareTime(current, videoLen) == 1) {
            current[0] = videoLen[0];
            current[1] = videoLen[1];
        }
    }
    
    public void movePrev(int[] videoLen, int[] current) {
        current[1] -= 10;
        if (current[1] < 0) {
            current[1] = (current[1] + 60) % 60;
            current[0] -= 1;
        }
        
        if (compareTime(new int[]{0, 0}, current) == 1) {
            current[0] = 0;
            current[1] = 0;
        }
    }
    
    public boolean isOpening(int[] op_start, int[] op_end, int[] current) {
        int compareStart = compareTime(op_start, current);
        int compareEnd = compareTime(current, op_end);
        
        boolean afterStart = (compareStart == -1) || (compareStart == 0);
        boolean beforeEnd = (compareEnd == -1);
        
        if (afterStart && beforeEnd) return true;
        return false;
    }
    
    public int compareTime(int[] timeA, int[] timeB) {
        if (timeA[0] == timeB[0]) {
            if (timeA[1] == timeB[1]) {
                return 0;
            }
            if (timeA[1] < timeB[1]) {
                return -1;
            }
            return 1;
        }
        
        if (timeA[0] < timeB[0]) {
            return -1;
        }
        
        return 1;
    }
}