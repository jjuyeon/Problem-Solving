package SWEA;

import java.util.Scanner;

public class D2_1204 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int tc = sc.nextInt();
            int[] scoreCount = new int[101];

            for(int i=0; i<1000; i++){
                int score = sc.nextInt();
                scoreCount[score]++;
            }

            int maxScore = -1;
            int maxCount = Integer.MIN_VALUE;
            for(int i=0; i<=100; i++){
                if(maxCount < scoreCount[i]){
                    maxCount = scoreCount[i];
                    maxScore = i;
                }
                else if(maxCount == scoreCount[i]){
                    maxScore = i;
                }
            }

            System.out.printf("#%d %d%n", test_case, maxScore);
        }
    }
}
