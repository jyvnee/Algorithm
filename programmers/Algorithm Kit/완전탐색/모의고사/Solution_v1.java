class Solution {
    public int[] solution(int[] answers) {
        int[] answer1 = {1, 2, 3, 4, 5};
        int[] answer2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] correctCount = new int[3];
        
        for (int i=0; i<answers.length; i++) {
            if (answers[i] == answer1[i % 5]) {
                correctCount[0]++;
            }
            if (answers[i] == answer2[i % 8]) {
                correctCount[1]++;
            }
            if (answers[i] == answer3[i % 10]) {
                correctCount[2]++;
            }
        }
        
        int max = Math.max(correctCount[0], Math.max(correctCount[1], correctCount[2]));
        
        boolean[] maxScore = new boolean[3];
        int count = 0;
        
        for (int i=0; i<3; i++) {
            if (max == correctCount[i]) {
                maxScore[i] = true;
                count++;
            }
        }
        
        int[] answer = new int[count];
        int index = 0;
        
        for (int i=0; i<3; i++) {
            if (maxScore[i]) {
                answer[index] = i+1;
                index++;
            }
        }
        
        return answer;
    }
}