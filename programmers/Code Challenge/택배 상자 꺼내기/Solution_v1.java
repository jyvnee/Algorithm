class Solution {
    public int solution(int n, int w, int num) {
        int topFloor = (int) Math.ceil((double) n / w);
        int topBoxCount = n % w;
        topBoxCount = (topBoxCount == 0) ? w : topBoxCount;
        
        int myBoxFloor = (int) Math.ceil((double) num / w);
        int myBoxCount = num % w;
        myBoxCount = (myBoxCount == 0) ? w : myBoxCount;
   
        if (topFloor % 2 == myBoxFloor % 2) {
            if (myBoxCount - topBoxCount <= 0) {
                return topFloor - myBoxFloor + 1;
            }
            return topFloor - myBoxFloor;
        } else {
            if (topBoxCount + myBoxCount > w) {
                return topFloor - myBoxFloor + 1;
            }
            return topFloor - myBoxFloor;
        }
    }
}