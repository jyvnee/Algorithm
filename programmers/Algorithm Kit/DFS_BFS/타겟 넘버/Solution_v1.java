class Solution {
    public int solution(int[] numbers, int target) {
        
        return dfs(numbers, target, 0, 0);
    }
    
    public int dfs(int[] numbers, int target, int current, int index) {
        if (index == numbers.length) {
            return current == target ? 1 : 0;
        }
        
        return dfs(numbers, target, current + numbers[index], index + 1) + dfs(numbers, target, current - numbers[index], index + 1);
    }
}