import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        List<Set<Integer>> dp = new ArrayList<>();
        
        dp.add(new HashSet<>());
        
        for (int i=1; i<=8; i++) {
            Set<Integer> currentSet = new HashSet<>();
            
            int repeatedNumber = makeRepeatedNumber(N, i);
            currentSet.add(repeatedNumber);
            
            for (int j=1; j<i; j++) {
                Set<Integer> leftSet = dp.get(j);
                Set<Integer> rightSet = dp.get(i-j);
                
                for (int a: leftSet) {
                    for (int b: rightSet) {
                        currentSet.add(a+b);
                        currentSet.add(a-b);
                        currentSet.add(a*b);
                        
                        if (b!=0) {
                            currentSet.add(a/b);
                        }
                    }
                }
            }
            if (currentSet.contains(number)) return i;
                
            dp.add(currentSet);
        }
        
        return -1;
    }
    
    private int makeRepeatedNumber(int N, int count) {
        int result = 0;
        
        for (int i=0; i<count; i++) {
            result = result*10 + N;
        }
        
        return result;
    }
}