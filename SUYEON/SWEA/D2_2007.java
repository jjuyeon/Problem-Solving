package SWEA;

import java.util.Scanner;

public class D2_2007 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String str = sc.next();
            for(int i=1; i<str.length(); i++){
                String standard = str.substring(0, i);
                String compare = str.substring(i, i+i);
                if(standard.equals(compare)){
                    System.out.printf("#%d %d%n", test_case, standard.length());
                    break;
                }
            }
        }
    }
}
