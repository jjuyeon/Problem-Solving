package BOJ;

import java.io.*;
import java.util.*;

public class BOJ20057 {
    static int[] dr = {0, 1, 0, -1}; // 좌, 하, 우, 상 (반시계 방향)
    static int[] dc = {-1, 0, 1, 0};
    static int n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = stoi(br.readLine());
        map = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = stoi(st.nextToken());
            }
        }

        System.out.print(move());
    }

    private static int move(){
        int ans = 0;
        int r = n/2, c = n/2; // 시작위치
        int dir = 0, len = 1, cnt = 0;

        while(true){
            if(r == 0 && c == 0) break; // 종료조건

            // 모래양 업데이트
            ans += spread(r, c, r+dr[dir], c+dc[dir], dir);
            cnt++;

            // 방향 업데이트
            r += dr[dir];
            c += dc[dir];

            if(cnt == len) { // 해당 방향으로 원하는만큼 위치 업데이트 완료
                dir = (dir + 1) % 4; // 방향 업데이트
                if (dir == 0 || dir == 2) ++len; // '위->왼쪽'로 갈 때 & '아래->오른쪽'로 갈때 길이가 1씩 증가함
                cnt = 0;
            }
        }

        return ans;
    }

    private static int spread(int r, int c, int nr, int nc, int dir){
        int outside = 0; // 격자 밖으로 나간 양

        // x->y로 이동
        int amount = map[nr][nc]; // y의 모래가 다음과 같은 비율로 흩날림
        int s1 = (int) (amount * 0.01);
        int s2 = (int) (amount * 0.02);
        int s5 = (int) (amount * 0.05);
        int s7 = (int) (amount * 0.07);
        int s10 = (int) (amount * 0.1);
        int a = amount - 2*(s1+s2+s7+s10)-s5;
        map[nr][nc] = 0; // y위치는 모래가 흩날리지 않음

        if(dir == 0 || dir == 2) { // 좌, 우
            //1%
            for(int i = 0; i < 2; i++) {
                int sr = r + dr[1+2*i];
                int sc = c + dc[1+2*i];
                if(sr>=0 && sr<n && sc>=0 && sc<n){
                    map[sr][sc] += s1;
                }
                else{
                    outside += s1;
                }
            }
            //2%
            for(int i = 0; i < 2; i++) {
                int sr = nr + dr[1+2*i]*2;
                int sc = nc + dc[1+2*i]*2;
                if(sr>=0 && sr<n && sc>=0 && sc<n){
                    map[sr][sc] += s2;
                }
                else{
                    outside += s2;
                }
            }
            //7%
            for(int i = 0; i < 2; i++) {
                int sr = nr + dr[1+2*i];
                int sc = nc + dc[1+2*i];
                if(sr>=0 && sr<n && sc>=0 && sc<n){
                    map[sr][sc] += s7;
                }
                else{
                    outside += s7;
                }
            }
            //10%
            for(int i = 0; i < 2; i++) {
                int sr = nr + dr[dir] + dr[1+2*i];
                int sc = nc + dc[dir] + dc[1+2*i];
                if(sr>=0 && sr<n && sc>=0 && sc<n){
                    map[sr][sc] += s10;
                }
                else{
                    outside += s10;
                }
            }
            //5%
            int sr = nr + dr[dir]*2;
            int sc = nc + dc[dir]*2;
            if(sr>=0 && sr<n && sc>=0 && sc<n){
                map[sr][sc] += s5;
            }
            else{
                outside += s5;
            }
            //나머지
            sr = nr + dr[dir];
            sc = nc + dc[dir];
            if(sr>=0 && sr<n && sc>=0 && sc<n){
                map[sr][sc] += a;
            }
            else{
                outside += a;
            }
        }
        else if(dir == 1 || dir == 3){ // 하, 상
            //1%
            for(int i = 0; i < 2; i++) {
                int sr = r + dr[2*i];
                int sc = c + dc[2*i];
                if(sr>=0 && sr<n && sc>=0 && sc<n){
                    map[sr][sc] += s1;
                }
                else{
                    outside += s1;
                }
            }
            //2%
            for(int i = 0; i < 2; i++) {
                int sr = nr + dr[2*i]*2;
                int sc = nc + dc[2*i]*2;
                if(sr>=0 && sr<n && sc>=0 && sc<n){
                    map[sr][sc] += s2;
                }
                else{
                    outside += s2;
                }
            }
            //7%
            for(int i = 0; i < 2; i++) {
                int sr = nr + dr[2*i];
                int sc = nc + dc[2*i];
                if(sr>=0 && sr<n && sc>=0 && sc<n){
                    map[sr][sc] += s7;
                }
                else{
                    outside += s7;
                }
            }
            //10%
            for(int i = 0; i < 2; i++) {
                int sr = nr + dr[dir] + dr[2*i];
                int sc = nc + dc[dir] + dc[2*i];
                if(sr>=0 && sr<n && sc>=0 && sc<n){
                    map[sr][sc] += s10;
                }
                else{
                    outside += s10;
                }
            }
            //5%
            int sr = nr + dr[dir]*2;
            int sc = nc + dc[dir]*2;
            if(sr>=0 && sr<n && sc>=0 && sc<n){
                map[sr][sc] += s5;
            }
            else{
                outside += s5;
            }
            //나머지
            sr = nr + dr[dir];
            sc = nc + dc[dir];
            if(sr>=0 && sr<n && sc>=0 && sc<n){
                map[sr][sc] += a;
            }
            else{
                outside += a;
            }
        }

        return outside;
    }

    private static int stoi(String str){
        return Integer.parseInt(str);
    }
}
