package SWEA;

import java.util.*;

public class D2_1966 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                list.add(sc.nextInt());
            }

            Collections.sort(list);

            StringBuilder sb = new StringBuilder();
            for(int number : list){
                sb.append(number).append(" ");
            }
            System.out.printf("#%d %s%n", test_case, sb.toString());
        }
    }
}
