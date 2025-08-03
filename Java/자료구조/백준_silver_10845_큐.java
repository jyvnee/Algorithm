import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);      
        int N = sc.nextInt();              

        Queue<Integer> queue = new LinkedList<>(); 

        for (int i = 0; i < N; i++) {    
            String command = sc.next();            

            if (command.equals("push")) {           
                int num = sc.nextInt();             
                queue.offer(num);                   // 큐에 정수를 넣는다 (offer는 add와 비슷한데, 실패할 경우 예외를 발생시키지 않음)
            } else if (command.equals("pop")) {
                System.out.println(queue.isEmpty()? -1 : queue.poll());
            } else if (command.equals("size")) {
                System.out.println(queue.size());   // 큐에 들어있는 정수의 개수를 출력
            } else if (command.equals("empty")) {
                System.out.println(queue.isEmpty()? 1: 0);
            } else if (command.equals("front")) {
                System.out.println(queue.isEmpty()? -1 : queue.peek());
            } else if (command.equals("back")) {
                System.out.println(queue.isEmpty()? -1 : ((LinkedList<Integer>) queue).getLast());
            }
        }
    }
}