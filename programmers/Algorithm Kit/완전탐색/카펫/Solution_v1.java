class Solution {
    public int[] solution(int brown, int yellow) {
        for (int h = 3, w = (brown - 2 * h) / 2 + 2; h<=w; h++, w--) {
            if ((h-2) * (w-2) == yellow) {
                return new int[] {w, h};
            }
        }
        
        return new int[] {};
    }
}