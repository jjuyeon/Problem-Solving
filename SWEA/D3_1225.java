package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D3_1225 {
    public static void main(String[] args){

        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int T = sc.nextInt();
            int count = 1;
            Queue<Integer> queue = new LinkedList<>();
            for(int i=0; i<8; i++){
                queue.offer(sc.nextInt());
            }

            while(true){
                if(count == 6){ // 한 cycle(1~5)
                    count = 1;
                }

                int top = queue.poll();
                int update = top - count;
                if(update <= 0){
                    queue.offer(0);
                    break;
                }
                queue.offer(update);
                count++;
            }

            sb.append("#").append(T);
            for(int i : queue){
                sb.append(" ").append(i);
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
        }
}
