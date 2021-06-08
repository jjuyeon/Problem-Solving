package SWEA;

import java.util.Scanner;

public class D2_1961 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            sc.nextLine();

            String[][] matrix = new String[n][n];
            for(int i=0; i<n; i++)
                matrix[i] = sc.nextLine().split(" ");

            String[][] rotation_90 = turning90(matrix, n);
            String[][] rotation_180 = turning90(rotation_90, n);
            String[][] rotation_270 = turning90(rotation_180, n);

            System.out.println("#"+test_case);
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++)
                    System.out.print(rotation_90[i][j]);
                System.out.print(" ");
                for(int j=0; j<n; j++)
                    System.out.print(rotation_180[i][j]);
                System.out.print(" ");
                for(int j=0; j<n; j++)
                    System.out.print(rotation_270[i][j]);
                System.out.println();
            }
        }
    }

    static String[][] turning90(String[][] standard, int n){
        String[][] temp = new String[n][n];
        for(int j=0; j<n; j++){
            for(int i=0; i<n; i++){
                temp[j][i] = standard[n-1-i][j];
            }
        }
        return temp;
    }
}
