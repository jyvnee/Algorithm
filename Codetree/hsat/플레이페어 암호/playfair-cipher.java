import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();
        String K = br.readLine();
        S = S.replace('J', 'I');
        K = K.replace('J', 'I');

        char[][] board = new char[5][5];
        int[][] positions = new int[26][2];
        boolean[] used = new boolean[26];

        String candidates = K + "ABCDEFGHIKLMNOPQRSTUVWXYZ";

        // 5x5 표 채우기
        makeBoard(board, candidates, positions, used);

        // 암호화 하려는 메시지를 두 글자씩 나누고 암호화
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index < S.length()) {
            char first = S.charAt(index);
            char second;

            // 마지막에 한 글자만 남은 경우
            if (index + 1 >= S.length()) {
                second = 'X';
                index++;
            } else {
                char next = S.charAt(index + 1);

                // 두 문자가 같은 경우
                if (first == next) {
                    second = (first == 'X') ? 'Q' : 'X';
                    index++;    // 첫 번째 문자만 사용. next는 다음 쌍에서 다시 처리
                } else {
                    second = next;
                    index += 2; // 두 문자 모두 사용
                }
            }

            // 암호화
            encryptPair(first, second, board, positions, sb);
        }

        System.out.print(sb);
    }

    public static void encryptPair(char first, char second, char[][] board, int[][] positions, StringBuilder sb) {
        int firstRow = positions[first - 'A'][0];
        int firstCol = positions[first - 'A'][1];
        int secondRow = positions[second - 'A'][0];
        int secondCol = positions[second - 'A'][1];

        // 같은 행인 경우
        if (firstRow == secondRow) {
            sb.append(board[firstRow][(firstCol + 1) % 5]);
            sb.append(board[secondRow][(secondCol + 1) % 5]);
            return;
        }

        // 같은 열인 경우
        if (firstCol == secondCol) {
            sb.append(board[(firstRow + 1) % 5][firstCol]);
            sb.append(board[(secondRow + 1) % 5][secondCol]);
            return;
        }

        // 서로 다른 행과 열
        sb.append(board[firstRow][secondCol]);
        sb.append(board[secondRow][firstCol]);
    }

    public static void makeBoard(char[][] board, String candidates, int[][] positions, boolean[] used) {
        int idx = 0;
        for (int i=0; i<candidates.length(); i++) {
            char ch = candidates.charAt(i);
            int charIdx = ch - 'A';

            if (used[charIdx]) continue;

            int row = idx / 5;
            int col = idx % 5;

            used[charIdx] = true;
            positions[charIdx][0] = row;
            positions[charIdx][1] = col;
            board[row][col] = ch;
            idx++;
        }
    }

    public static void addLastChar(List<String> list) {
        int lastIdx = list.size() - 1;
        String lastWord = list.get(lastIdx);

        if (lastWord.length() == 1) {
            list.set(lastIdx, lastWord + "X");
        }
    }
}