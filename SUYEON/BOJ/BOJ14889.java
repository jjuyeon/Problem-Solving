package BOJ;

import java.io.*;
import java.util.*;

public class BOJ14889 {

    static int n, ans;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = stoi(br.readLine());

        arr = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = stoi(st.nextToken());
            }
        }

        ans = Integer.MAX_VALUE;
        combination(0, 0, new boolean[n]);
        System.out.print(ans);
    }

    private static void combination(int start, int cnt, boolean[] selected){
        if(cnt == n/2){ // 2팀으로 나누기
            int now = getDiff(selected); // 스타트 팀과 링크 팀의 능력치의 차이값 구하기
            ans = Math.min(ans, now); // 최소값 업데이트
            return;
        }
        for(int i=start; i<n; i++){ // 조합 사용
            if(!selected[i]){
                selected[i] = true;
                combination(i+1, cnt+1, selected);
                selected[i] = false;
            }
        }
    }

    private static int getDiff(boolean[] s){
        int startTeam = 0, linkTeam = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(s[i] && s[j]){ // arr[i][j] 와 세트로 arr[j][i]를 더하기 위함
                    startTeam += arr[i][j];
                }
                else if(!s[i] && !s[j]){
                    linkTeam += arr[i][j];
                }
            }
        }
        return Math.abs(startTeam-linkTeam);
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
