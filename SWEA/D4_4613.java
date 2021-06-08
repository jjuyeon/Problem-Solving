package SWEA;

import java.io.*;
import java.util.*;

public class D4_4613 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            char[][] flag = new char[n][m];
            for(int i=0; i<n; i++){
                flag[i] = br.readLine().toCharArray();
            }

            int[][] colorCnt = new int[n][3]; // 0:W, 1:B, 2:R
            for(int i=0; i<n;i++){
                for(int j=0; j<m; j++){
                    if(flag[i][j] == 'W') colorCnt[i][0]++;
                    else if(flag[i][j] == 'B') colorCnt[i][1]++;
                    else if(flag[i][j] == 'R') colorCnt[i][2]++;
                }
            }

            /**
             * W가 나올 수 있는 행: 1 ~ N-2
             * B가 나올 수 있는 행: 2 ~ N-1
             * R가 나올 수 있는 행: 3 ~ N
             */
            int sum = 0;
            for(int i=1; i<=n-2; i++){
                for(int j=i+1; j<=n-1; j++){
                    int temp = 0;
                    for(int k=0; k<i; k++) temp += colorCnt[k][0];
                    for(int k=i; k<j; k++) temp += colorCnt[k][1];
                    for(int k=j; k<n; k++) temp += colorCnt[k][2];

                    sum = Math.max(sum, temp);
                }
            }

            int ans = n*m - sum;
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }

        System.out.print(sb.toString());
    }
}
