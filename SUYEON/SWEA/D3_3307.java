package SWEA;

import java.util.*;

public class D3_3307 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] LIS = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }

            int max = 0;
            for(int i=0; i<n; i++){
                LIS[i] = 1;
                for(int j=0; j<i; j++){
                    if(arr[j]<arr[i] && LIS[i]<LIS[j]+1){
                        LIS[i] = LIS[j]+1;
                    }
                }
                max = Math.max(max, LIS[i]);
            }

            System.out.println("#"+test_case+" "+max);
        }
    }
}
