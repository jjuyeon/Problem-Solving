package SWEA;

import java.util.*;

/**
 * 별찍기 문제와 매우 유사 -> index가 어떻게 변화하는지 캐치하는데 시간이 오래 걸림 ㅠ
 */
public class D3_2805 {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[][] farm = new int[N][N];
            for(int i=0; i<N; i++){
                String str = sc.next();
                for(int j=0; j<N; j++){
                    farm[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                }
            }

            int sum = 0;
            for(int i=0; i<=N/2; i++){ // 증가하는 부분
                for(int j=N/2-i; j<=N/2+i; j++){
                    sum += farm[i][j];
                }
            }
            for(int i=N/2-1; i>=0; i--){ // 감소하는 부분
                for(int j=N/2-i; j<=N/2+i; j++){
                    sum += farm[N-1-i][j];
                }
            }
            sb.append("#").append(test_case).append(" ").append(sum).append("\n");
        }
        System.out.print(sb.toString());
    }
}
