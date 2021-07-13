package Jungol;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JO1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String cmd = sc.next();
            switch (cmd) {
                case "i":
                    queue.offer(Integer.parseInt(sc.next()));
                    break;
                case "c":
                    System.out.println(queue.size());
                    break;
                case "o":
                    if(queue.isEmpty()) {
                        System.out.println("empty");
                    } else {
                        System.out.println(queue.poll());
                    }
            }
        }
    }
}
