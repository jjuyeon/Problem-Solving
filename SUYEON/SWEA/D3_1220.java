package SWEA;

import java.util.Scanner;

public class D3_1220 {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = sc.nextInt();
            int[][] table = new int[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    table[i][j] = sc.nextInt();
                }
            }

            int count = 0;
            boolean isContinued, isTwo;

            for(int j=0; j<n; j++){
                isContinued = false; isTwo = false;
                for(int i=0; i<n; i++){
                    if(!isContinued && table[i][j] == 1){
                        isContinued = true;
                        isTwo = false;
                    }
                    else if(isContinued && !isTwo && table[i][j] == 2){
                        count++;
                        isContinued =false;
                        isTwo = true;
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(count).append("\n");
        }
        System.out.print(sb.toString());
    }
}
