package BOJ;

import java.io.*;
import java.util.*;

public class BOJ17144 {

    static int r, c;
    static Dust[][] map;

    static class Dust {
        int standard, plus;
        Dust(int standard, int plus){
            this.standard = standard; // 한 턴에서 미세먼지가 확산될 때, 해당 공간에서 다른 공간으로 나누어지는 먼지의 기준 값
            this.plus = plus; // 한 턴에서 해당 공간에 추가되는 미세먼지 값
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = stoi(st.nextToken()); // 행
        c = stoi(st.nextToken()); // 열
        int t = stoi(st.nextToken()); // 시간

        int cleanerIdx = -1;
        map = new Dust[r][c];
        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++){
                map[i][j] = new Dust(stoi(st.nextToken()), 0);
                if(cleanerIdx == -1 && map[i][j].standard == -1){ // cleaner 시작 행 인덱스 찾기
                    cleanerIdx = i;
                }
            }
        }

        for(int time=1; time<=t; time++){
            // 먼지 확산
            startSpread();
            // 확산 확정된 값으로 업데이트
            completeSpread();

            // 공기청정기 작동
            clean(cleanerIdx);
        }

        // 미세먼지 양 출력
        printDustAmount();
    }

    private static void startSpread(){
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j].standard > 0){ // 먼지
                    int amount = map[i][j].standard/5; // 확산되는 양은 Ar,c/5이고 소수점은 버린다.
                    int cnt = 0; // 확산된 방향의 개수
                    for(int k=0; k<4; k++){
                        int nr = i+dr[k];
                        int nc = j+dc[k];
                        if(nr<0 || nr>=r || nc<0 || nc>=c || map[nr][nc].standard == -1) continue; // 범위 넘어가고 공기청정기면 업데이트 X
                        map[nr][nc].plus += amount;
                        ++cnt;
                    }
                    map[i][j].standard -= amount*cnt; // (r, c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수)
                }
            }
        }
    }

    private static void completeSpread(){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j].standard != -1) {
                    map[i][j].standard += map[i][j].plus;
                    map[i][j].plus = 0;
                }
            }
        }
    }

    private static void clean(int cleanerIdx){
        // 바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
        // 공기청정기로 들어간 미세먼지는 모두 정화된다.

        // 위쪽 공기청정기의 바람은 반시계방향으로 순환
        Dust temp = map[0][0];
        for(int j=0; j<c-1; j++){ // 좌
            map[0][j] = map[0][j+1];
        }

        for(int i=0; i<cleanerIdx; i++) { // 상
            map[i][c-1] = map[i+1][c-1];
        }

        for(int j=c-1; j>1; j--) { // 우
            map[cleanerIdx][j] = map[cleanerIdx][j-1];
        }
        map[cleanerIdx][1] = new Dust(0, 0);

        for(int i=cleanerIdx-1; i>1; i--){ // 하
            map[i][0] = map[i-1][0];
        }
        map[1][0] = temp;

        // 아래쪽 공기청정기의 바람은 시계방향으로 순환
        temp = map[cleanerIdx+1][c-1];
        for(int j=c-1; j>1; j--){ // 우
            map[cleanerIdx+1][j] = map[cleanerIdx+1][j-1];
        }
        map[cleanerIdx+1][1] = new Dust(0, 0);

        for(int i=cleanerIdx+2; i<r-1; i++){ // 상
            map[i][0] = map[i+1][0];
        }

        for(int j=0; j<c-1; j++){ // 좌
            map[r-1][j] = map[r-1][j+1];
        }

        for(int i=r-1; i>cleanerIdx+2; i--){ // 하
            map[i][c-1] = map[i-1][c-1];
        }
        map[cleanerIdx+2][c-1] = temp;
    }

    private static void printDustAmount(){
        int result = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j].standard > 0){
                    result += map[i][j].standard;
                }
            }
        }
        System.out.print(result);
    }

    private static int stoi(String str){
        return Integer.parseInt(str);
    }
}
