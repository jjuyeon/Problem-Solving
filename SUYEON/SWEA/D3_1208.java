package SWEA;

import java.util.Scanner;
import java.util.Arrays;

public class D3_1208 {
    public static void main(String[] args){
        int T = 10;
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int k = sc.nextInt();

            int[] box = new int[100];
            for(int i=0; i<100; i++){
                box[i] = sc.nextInt();
            }

            while (k > 0) {
                Arrays.sort(box);
                box[0]++;
                box[99]--;
                k--;
            }

            Arrays.sort(box); // 마지막 값까지 오른차순 업데이트
            sb.append("#").append(test_case).append(" ").append(box[99]-box[0]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
