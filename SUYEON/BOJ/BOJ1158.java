package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1158 {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++){
            queue.add(i);
        }

        int cnt = 1;
        while(queue.size() > 1){
            if(cnt == k) {
                sb.append(queue.poll()).append(", ");
                cnt = 0;
            }
            else {
                queue.add(queue.poll());
            }
            cnt++; // 한 턴 끝남
        }
        sb.append(queue.poll());

        System.out.print("<"+sb.toString()+">");
    }
}
