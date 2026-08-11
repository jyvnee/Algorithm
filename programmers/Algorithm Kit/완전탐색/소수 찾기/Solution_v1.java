import java.util.*;

class Solution {
    boolean[] visited;
    Set<Integer> primes;
    char[] digits;
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        primes = new HashSet<>();
        digits = new char[numbers.length()];
        
        for (int i=0; i<numbers.length(); i++) {
            digits[i] = numbers.charAt(i);
        }
        
        dfs(0);
        
        return primes.size();
    }
    
    public void dfs(int current) {
        if (isPrime(current)) {
            primes.add(current);
        }
        
        for (int i=0; i<visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(current * 10 + (digits[i] - '0'));
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n) {
        if (n < 2) return false;
        
        for (int divisor = 2; divisor <= n / divisor; divisor++) {
            if (n % divisor == 0) return false;
        }
        
        return true;
    }
}
