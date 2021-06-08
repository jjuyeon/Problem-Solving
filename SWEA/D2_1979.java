package SWEA;

import java.util.Scanner;

public class D2_1979 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt(), k = sc.nextInt();
            sc.nextLine();

            String[][] puzzle = new String[n][n];
            for(int i=0; i<n; i++)
                puzzle[i] = sc.nextLine().split(" ");

            int answer = 0;
            int count;
            // 가로
            for(int i=0; i<n; i++){
                count = 0;
                for(int j=0; j<n; j++){
                    if(puzzle[i][j].equals("0")){
                        if(count == k)
                            answer++;
                        count = 0;
                    }
                    else if(puzzle[i][j].equals("1")){
                        count++;
                    }
                }
                if(count == k)
                    answer++;
            }

            // 세로
            for(int i=0; i<n; i++){
                count = 0;
                for(int j=0; j<n; j++){
                    if(puzzle[j][i].equals("0")){
                        if(count == k)
                            answer++;
                        count = 0;
                    }
                    else if(puzzle[j][i].equals("1")){
                        count++;
                    }
                }
                if(count == k)
                    answer++;
            }

            System.out.printf("#%d %d%n", test_case, answer);
        }
    }
}
