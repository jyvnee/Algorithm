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
        Map<Character, int[]> charPositon = new HashMap<>();
        Set<Character> charSet = new HashSet<>();

        // 5x5 표 채우기
        int idx = 0;
        for (int i=0; i<K.length(); i++) {
            char ch = K.charAt(i);
            if (ch == 'J') ch = 'I';
            if (charSet.contains(ch)) continue;

            int row = idx / 5;
            int col = idx % 5;

            charSet.add(ch);
            charPositon.put(ch, new int[]{row, col});
            board[row][col] = ch;
            idx++;
        }

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            if (ch == 'J') continue;
            if (charSet.contains(ch)) continue;

            int row = idx / 5;
            int col = idx % 5;

            charSet.add(ch);
            charPositon.put(ch, new int[]{row, col});
            board[row][col] = ch;
            idx++;
        }

        // 암호화 하려는 메시지를 두 글자씩 나누기
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(S.charAt(0)));

        for (int i = 1; i < S.length(); i++) {
            char ch = S.charAt(i);

            int lastIdx = list.size() - 1;
            String lastWord = list.get(lastIdx);

            if (lastWord.length() == 2) {
                list.add(String.valueOf(S.charAt(i)));
            } else {
                char resultChar = ch;

                if (ch == lastWord.charAt(0)) {
                    if (lastWord.charAt(0) == 'X') {
                        resultChar = 'Q';
                    } else {
                        resultChar = 'X';
                    }

                    list.set(lastIdx, list.get(lastIdx) + resultChar);
                    list.add(String.valueOf(S.charAt(i)));
                } else {
                    list.set(lastIdx, list.get(lastIdx) + resultChar);
                }
            }
        }
        addLastChar(list);

        // 쌍을 만든 두 글자 암호화하기
        StringBuilder sb = new StringBuilder();
        for (String word : list) {
            char first = word.charAt(0);
            char second = word.charAt(1);

            int[] firstPos = charPositon.get(first);
            int[] secondPos = charPositon.get(second);

            if (firstPos[0] == secondPos[0]) {
                char firstEncryption = board[firstPos[0]][(firstPos[1] + 1) % 5];
                char secondEncryption = board[secondPos[0]][(secondPos[1] + 1) % 5];
                sb.append(firstEncryption).append(secondEncryption);
            } else if (firstPos[1] == secondPos[1]) {
                char firstEncryption = board[(firstPos[0] + 1) % 5][firstPos[1]];
                char secondEncryption = board[(secondPos[0] + 1) % 5][secondPos[1]];
                sb.append(firstEncryption).append(secondEncryption);
            } else {
                char firstEncryption = board[firstPos[0]][secondPos[1]];
                char secondEncryption = board[secondPos[0]][firstPos[1]];
                sb.append(firstEncryption).append(secondEncryption);
            }
        }

        System.out.print(sb);
    }

    public static void addLastChar(List<String> list) {
        int lastIdx = list.size() - 1;
        String lastWord = list.get(lastIdx);

        if (lastWord.length() == 1) {
            list.set(lastIdx, lastWord + "X");
        }
    }
}