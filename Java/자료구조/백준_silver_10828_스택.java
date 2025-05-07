import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
             
            Deque<Integer> stack = new ArrayDeque<>();
            int n = Integer.parseInt(reader.readLine());

            for (int i = 0; i < n; i++) {
                String command = reader.readLine();

                if (command.startsWith("push")) {
                    String[] parts = command.split(" ");
                    int num = Integer.parseInt(parts[1]);
                    stack.push(num);
                } else if (command.equals("pop")) {
                    if (stack.isEmpty()) {
                        writer.write("-1");
                    } else {
                        writer.write(String.valueOf(stack.pop()));
                    }
                    writer.newLine();
                } else if (command.equals("size")) {
                    writer.write(String.valueOf(stack.size()));
                    writer.newLine();
                } else if (command.equals("empty")) {
                    writer.write(stack.isEmpty() ? "1" : "0");
                    writer.newLine();
                } else if (command.equals("top")) {
                    if (stack.isEmpty()) {
                        writer.write("-1");
                    } else {
                        writer.write(String.valueOf(stack.peek()));
                    }
                    writer.newLine();
                }
            }
            writer.flush(); // 버퍼 비우기
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}