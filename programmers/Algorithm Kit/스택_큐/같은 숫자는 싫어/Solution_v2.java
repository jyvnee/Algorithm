import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int writeIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (writeIndex == 0 || arr[writeIndex - 1] != arr[i]) {
                arr[writeIndex++] = arr[i];
            }
        }

        return Arrays.copyOf(arr, writeIndex);
    }
}
