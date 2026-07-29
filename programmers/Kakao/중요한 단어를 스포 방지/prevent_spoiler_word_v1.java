import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int n = message.length();
        boolean[] covered = new boolean[n];
        
        for (int[] range : spoiler_ranges) {
            int start = range[0];
            int end = range[1];
            
            for (int i=start; i<=end; i++) {
                covered[i] = true;
            }
        }
        
        Set<String> normalWords = new HashSet<>();
        Set<String> spoilerWords = new HashSet<>();
        
        int start = 0;
        
        while (start < n) {
            int end = start;
            boolean isSpoilerWord = false;
            
            while (end < n && message.charAt(end) != ' ') {
                if (covered[end]) {
                    isSpoilerWord = true;
                }
                end++;
            }
            
            String word = message.substring(start, end);
            
            if (isSpoilerWord) {
                spoilerWords.add(word);
            } else {
                normalWords.add(word);
            }
            
            start = end + 1;
        }
        
        spoilerWords.removeAll(normalWords);
        
        return spoilerWords.size();
    }
}