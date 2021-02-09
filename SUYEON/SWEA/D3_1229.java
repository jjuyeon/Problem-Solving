package SWEA;

import java.util.LinkedList;
import java.util.Scanner;

public class D3_1229 {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = sc.nextInt();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i=0; i<n; i++){
                list.add(sc.nextInt());
            }

            int command = sc.nextInt();
            for(int i=0; i<command; i++){
                String code = sc.next();
                int x = sc.nextInt();
                int y = sc.nextInt();
                if(code.equals("I")) {
                    for(int j=0; j<y; j++) {
                        list.add(x++, sc.nextInt());
                    }
                }
                else if(code.equals("D")) {
                    for(int j=0; j<y; j++) {
                        list.remove(x);
                    }
                }
            }

            sb.append("#").append(test_case).append(" ");
            for(int i=0; i<10; i++){
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
