package BOJ;

import java.util.*;

public class BOJ7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weight = new int[n];
        int[] height = new int[n];
        for(int i=0; i<n; i++){
            weight[i] = sc.nextInt();
            height[i] = sc.nextInt();
        }

        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            int rank = 1;
            for(int j=0; j<n; j++){
                if(weight[i]<weight[j] && height[i]<height[j]){
                    rank++;
                }
            }
            ans[i] = rank;
        }

        for(int i : ans){
            System.out.print(i + " ");
        }
    }
}
