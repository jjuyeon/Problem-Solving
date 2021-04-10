package BOJ;

import java.util.*;

// 도움되었던 반례 모음: https://www.acmicpc.net/board/view/29779
/*
7
2 2 2 2 2 2 2
2 0 2 2 2 2 2
2 0 2 2 2 2 2
2 0 2 2 2 2 2
2 2 2 0 2 2 2
2 2 2 2 2 2 0
2 2 2 2 2 2 0

=> 32


10
8 8 4 16 32 0 0 8 8 8
8 8 4 0 0 8 0 0 0 0
16 0 0 16 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 16
0 0 0 0 0 0 0 0 0 2

=>128
 */

public class BOJ12100 {

    static int[] dir = {-1, 1}; // 상(좌)하(우)
    static int[][] game;
    static int n, ans;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        game = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                game[i][j] = sc.nextInt();
            }
        }

        ans = 2;
        simul(0, new int[5]);
        System.out.print(ans);
    }


    // 20*20(map의 크기)*20(최대 한 줄 이동 하니까)*4^5(순열로 완탐했을 때)
    // 계산결과 1억보다 작다! 그러므로, 완탐 돌려도 된다
    private static void simul(int idx, int[] order){
        if(idx == 5){ // 순서 다 정해졌으면 그 순서대로 블록 이동 시작
            int[][] temp_game = copyGameStatus();
            move(temp_game, order);
            ans = Math.max(ans, getMaxValue(temp_game));
            return;
        }

        for(int i=0; i<4; i++){ // 모든 순서 경우의 수 구하기
            order[idx] = i;
            simul(idx+1, order);
        }
    }

    private static void move(int[][] map, int[] order){
        for(int i=0; i<5; i++){
            switch(order[i]){
                case 0:
                    moveUp(map);
                    break;
                case 1:
                    moveDown(map);
                    break;
                case 2:
                    moveLeft(map);
                    break;
                case 3:
                    moveRight(map);
            }
        }
    }

    private static void moveUp(int[][] map){
        boolean[][] isSum = new boolean[n][n];

        for(int j=0; j<n; j++){
            for(int i=1; i<n; i++){
                if(map[i][j] == 0) continue; // 현재 탐색하는 블럭이 빈칸이면 탐색할 필요 없음

                int nr = i+dir[0];
                while(nr>0 && map[nr][j] == 0) --nr;

                if(map[nr][j] == map[i][j] && !isSum[nr][j]){ // 합쳐질 수 있으면(한번도 합쳐진 적 없어야함)
                    map[nr][j] *= 2; // 합친다
                    isSum[nr][j] = true;
                    map[i][j] = 0; // 합쳐진 블럭은 0으로 업데이트한다
                }
                else { // 합칠 수 없으면
                    if(map[nr][j] == 0){ // 합칠 수 없는 이유가 블럭이 0이기 때문이라면
                        map[nr][j] = map[i][j]; // 그냥 그 자리에 넣어준다
                        map[i][j] = 0; // 움직인 블럭은 0으로 업데이트한다
                    }
                    else if(nr+1 != i){ // 원래 자리에서 블럭이 움직이지 않는 경우 제외
                        map[nr+1][j] = map[i][j]; // 밑에 붙인다
                        map[i][j] = 0; // 움직인 블럭은 0으로 업데이트한다
                    }
                }
            }
        }
    }

    private static void moveDown(int[][] map){
        boolean[][] isSum = new boolean[n][n];

        for(int j=0; j<n; j++){
            for(int i=n-2; i>=0; i--){
                if(map[i][j] == 0) continue; // 현재 탐색하는 블럭이 빈칸이면 탐색할 필요 없음

                int nr = i+dir[1];
                while(nr<n-1 && map[nr][j] == 0) ++nr;

                if(map[nr][j] == map[i][j] && !isSum[nr][j]){ // 합쳐질 수 있으면(한번도 합쳐진 적 없어야함)
                    map[nr][j] *= 2; // 합친다
                    isSum[nr][j] = true;
                    map[i][j] = 0; // 합쳐진 블럭은 0으로 업데이트한다
                }
                else { // 합칠 수 없으면
                    if(map[nr][j] == 0){ // 합칠 수 없는 이유가 블럭이 0이기 때문이라면
                        map[nr][j] = map[i][j]; // 그냥 그 자리에 넣어준다
                        map[i][j] = 0; // 움직인 블럭은 0으로 업데이트한다
                    }
                    else if(nr-1 != i){ // 원래 자리에서 블럭이 움직이지 않는 경우 제외
                        map[nr-1][j] = map[i][j]; // 위에 붙인다
                        map[i][j] = 0; // 움직인 블럭은 0으로 업데이트한다
                    }
                }
            }
        }
    }

    private static void moveLeft(int[][] map){
        boolean[][] isSum = new boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=1; j<n; j++){
                if(map[i][j] == 0) continue; // 현재 탐색하는 블럭이 빈칸이면 탐색할 필요 없음

                int nc = j+dir[0];
                while(nc>0 && map[i][nc] == 0) --nc;

                if(map[i][nc] == map[i][j] && !isSum[i][nc]){ // 합쳐질 수 있으면(한번도 합쳐진 적 없어야함)
                    map[i][nc] *= 2; // 합친다
                    isSum[i][nc] = true;
                    map[i][j] = 0; // 합쳐진 블럭은 0으로 업데이트한다
                }
                else { // 합칠 수 없으면
                    if(map[i][nc] == 0){ // 합칠 수 없는 이유가 블럭이 0이기 때문이라면
                        map[i][nc] = map[i][j]; // 그냥 그 자리에 넣어준다
                        map[i][j] = 0; // 움직인 블럭은 0으로 업데이트한다
                    }
                    else if(nc+1 != j){ // 원래 자리에서 블럭이 움직이지 않는 경우 제외
                        map[i][nc+1] = map[i][j]; // 오른쪽에 붙인다
                        map[i][j] = 0; // 움직인 블럭은 0으로 업데이트한다
                    }
                }
            }
        }
    }

    private static void moveRight(int[][] map){
        boolean[][] isSum = new boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=n-2; j>=0; j--){
                if(map[i][j] == 0) continue; // 현재 탐색하는 블럭이 빈칸이면 탐색할 필요 없음

                int nc = j+dir[1];
                while(nc<n-1 && map[i][nc] == 0) ++nc;

                if(map[i][nc] == map[i][j] && !isSum[i][nc]){ // 합쳐질 수 있으면(한번도 합쳐진 적 없어야함)
                    map[i][nc] *= 2; // 합친다
                    isSum[i][nc] = true;
                    map[i][j] = 0; // 합쳐진 블럭은 0으로 업데이트한다
                }
                else { // 합칠 수 없으면
                    if(map[i][nc] == 0){ // 합칠 수 없는 이유가 블럭이 0이기 때문이라면
                        map[i][nc] = map[i][j]; // 그냥 그 자리에 넣어준다
                        map[i][j] = 0; // 움직인 블럭은 0으로 업데이트한다
                    }
                    else if(nc-1 != j){ // 원래 자리에서 블럭이 움직이지 않는 경우 제외
                        map[i][nc-1] = map[i][j]; // 왼쪽에 붙인다
                        map[i][j] = 0; // 움직인 블럭은 0으로 업데이트한다
                    }
                }
            }
        }
    }

    private static int getMaxValue(int[][] map){ // 최대값을 가지는 블럭 찾기
        int max = 2;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] > max){
                    max = map[i][j];
                }
            }
        }
        return max;
    }

    private static int[][] copyGameStatus(){ // 다음 경우의 수를 탐색하기 위해, 원래 배열로 초기화하기
        int[][] temp_game = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                temp_game[i][j] = game[i][j];
            }
        }
        return temp_game;
    }
}
