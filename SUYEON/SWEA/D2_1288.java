package SWEA;

import java.util.Scanner;

public class D2_1288 {
    static boolean[] checkNumber;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int result = 0;
            checkNumber = new boolean[10];

            while(!isAll()){
                result += 1;
                String itos = Integer.toString(n * result);
                for(int i = 0; i<itos.length(); i++){
                    int idx = Integer.parseInt(String.valueOf(itos.charAt(i)));
                    checkNumber[idx] = true;
                }
            }

            System.out.printf("#%d %d%n", test_case, n * result);
        }
    }

    static boolean isAll(){
        for(int i=0; i<10; i++){
            if(!checkNumber[i]){
                return false;
            }
        }
        return true;
    }
}
