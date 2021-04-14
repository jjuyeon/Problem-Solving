package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class D4_7699 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1 ,1};
    static int[][] map;
    static int R, C, ans;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            R = Integer.parseInt(sc.next());
            C = Integer.parseInt(sc.next());

            map = new int[R][C];
            for(int i=0; i<R; i++){
                String str = sc.next();
                for(int j=0; j<C; j++){
                    map[i][j] = str.charAt(j) - 'A';
                }
            }
            ans = 0;
            dfs(0, 0, 1, new boolean[26]);
            System.out.println("#"+test_case+" "+ans);
        }
    }

    private static void dfs(int r, int c, int cnt, boolean[] alpha){
        alpha[map[r][c]] = true; // 한턴 시작
        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr <0 || nr >=R || nc<0 || nc>=C || alpha[map[nr][nc]]) continue;
            dfs(nr, nc, cnt+1, alpha);
        }
        ans = Math.max(ans, cnt);
        alpha[map[r][c]] = false; // 한턴 끝
    }
}
