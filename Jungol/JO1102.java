package Jungol;

import java.util.Scanner;
import java.util.Stack;

public class JO1102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            switch (command) {
                case "i" :
                    stack.push(Integer.parseInt(sc.next()));
                    break;
                case "o" :
                    if(stack.isEmpty()) {
                        System.out.println("empty");
                    } else {
                        System.out.println(stack.pop());
                    }
                    break;
                case "c" :
                    System.out.println(stack.size());
            }
        }
    }
}
