package BOJ;

import java.io.*;
import java.util.*;

// 개선방법: https://www.acmicpc.net/board/view/48643
// 이렇게 바꾸면 2516ms -> 584ms로 최적화 가능

public class BOJ17143 {

    static class Shark{
        int speed, dir, z;

        Shark(int speed, int dir, int z){
            this.speed = speed;
            this.dir = dir;
            this.z = z;
        }
    }

    static int r,c;
    static Shark[][] map;
    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = stoi(st.nextToken());
        c = stoi(st.nextToken());
        int m = stoi(st.nextToken());

        map = new Shark[r+1][c+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int row = stoi(st.nextToken());
            int col = stoi(st.nextToken());
            int speed = stoi(st.nextToken());
            int dir = stoi(st.nextToken());
            int size = stoi(st.nextToken());
            if(dir == 1 || dir == 2) {
                speed %= (2*r - 2);
            }
            else {
                speed %= (2*c - 2);
            }
            map[row][col] = new Shark(speed, dir, size);
        }

        simulation();
    }

    private static void simulation(){
        int totalSharkSize = 0;

        // 1. 낚시왕이 오른쪽으로 한 칸 이동한다. 가장 오른쪽 열의 오른쪽 칸에 이동하면 이동을 멈춘다.
        for(int time=1; time<=c; time++){
            // 2. 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
            totalSharkSize += getCloseSharkSize(time);
            // 3. 상어가 이동한다.
            move();
        }
        System.out.print(totalSharkSize);
    }

    private static int getCloseSharkSize(int col){
        int size = 0;

        for(int i=1; i<=r; i++){
            if(map[i][col] != null){
                size += map[i][col].z;
                map[i][col] = null;
                break;
            }
        }
        return size;
    }

    private static void move(){
        Shark[][] temp = new Shark[r+1][c+1];

        for(int i=1; i<=r; i++){
            for(int j=1; j<=c; j++){
                if(map[i][j] != null){
                    int nr = i, nc = j;
                    int ns = map[i][j].speed, nd = map[i][j].dir, nz = map[i][j].z;

                    if(map[i][j].speed > 0) {
                        int[] updatePos = updateSharkPos(i, j, map[i][j]);
                        nr = updatePos[0];
                        nc = updatePos[1];
                        nd = updatePos[2];
                    }

                    if(temp[nr][nc] != null){
                        if(temp[nr][nc].z < nz){
                            temp[nr][nc] = new Shark(ns, nd, nz);
                        }
                    } else {
                        temp[nr][nc] = new Shark(ns, nd, nz);
                    }

                    map[i][j] = null;
                }
            }
        }

        copyMap(temp);
    }

    private static int[] updateSharkPos(int sr, int sc, Shark shark){
        int d = shark.dir, speed = shark.speed;
        for(int i=1; i<=speed; ){
            int nr = sr + dr[d];
            int nc = sc + dc[d];
            if(nr<=0 || nr>r || nc<=0 || nc>c){
                d = changeDirection(d);
                continue;
            }
            sr = nr;
            sc = nc;
            ++i;
        }

        return new int[]{sr, sc, d};
    }

    private static int changeDirection(int d){
        if(d == 1) return 2;
        else if(d == 2) return 1;
        else if(d == 3) return 4;
        else return 3;
    }

    private static void copyMap(Shark[][] temp){
        for(int i=1; i<=r; i++){
            for(int j=1; j<=c; j++){
                map[i][j] = temp[i][j];
            }
        }
    }

    private static int stoi(String str){
        return Integer.parseInt(str);
    }
}
