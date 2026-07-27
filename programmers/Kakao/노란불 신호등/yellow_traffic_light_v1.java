import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        
        int[] periods = new int[signals.length];
        periods[0] = signals[0][0] + signals[0][1] + signals[0][2];
        int commonPeriod = periods[0];
        
        for (int i=1; i<signals.length; i++) {
            periods[i] = signals[i][0] + signals[i][1] + signals[i][2];
            commonPeriod = lcm(commonPeriod, periods[i]);
        }
        
        // 한 주기만 탐색
        for (int i=1; i<=commonPeriod; i++) {
            if (isAllYellow(i, signals, periods)) return i;
        }
        
        return -1;
    }
    
    public boolean isAllYellow(int time, int[][] signals, int[] periods) {
        for (int s=0; s<signals.length; s++) {
            int period = periods[s];
            if (time % period <= signals[s][0] || time % period > (signals[s][0] + signals[s][1])) {
                return false;
            }
        }
        return true;
    }
    
    // 최대공약수
    public int gcd(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
    
    // 최소공배수
    public int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}