package BOJ;

import java.io.*;
import java.util.*;

// 참고: https://girawhale.tistory.com/entry/%EB%B0%B1%EC%A4%80-1074%EB%B2%88-Z-JAVA?category=915305

public class BOJ1074 { // 분할정복

    static int findR, findC, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        findR = Integer.parseInt(st.nextToken());
        findC = Integer.parseInt(st.nextToken());

        dfs(n, 0, 0);
    }

    private static void dfs(int n, int r, int c){
        if(findR == r && findC == c){
            System.out.print(ans);
            System.exit(0);
        }

        if(r<=findR && findR<r+n && c<=findC && findC<c+n){
            // 왼쪽 위칸
            dfs(n/2, r, c);
            // 오른쪽 위칸
            dfs(n/2, r, c+n/2);
            // 왼쪽 아래칸
            dfs(n/2, r+n/2, c);
            // 오른쪽 아래칸
            dfs(n/2, r+n/2, c+n/2);
        }
        else{
            ans += n*n;
        }
    }
}
