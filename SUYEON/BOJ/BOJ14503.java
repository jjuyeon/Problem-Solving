package BOJ;

import java.util.*;

public class BOJ14503 {

    static int n, m;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int[] robot = {sc.nextInt(), sc.nextInt()};
        int robot_dir = sc.nextInt();

        map = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        clean(robot, robot_dir);
    }

    private static void clean(int[] robot, int d){
        boolean[][] isCleaned = new boolean[n][m]; // 청소한 위치임을 체크하기 위함
        int r = robot[0];
        int c = robot[1];
        isCleaned[r][c] = true;
        int ans = 1;

        while(true){
            // 4 방향 모두 청소가 이미 되어있거나 벽
            if(isFinished(r, c, isCleaned)){
                int nr = r + dr[d] * -1; // 후진
                int nc = c + dc[d] * -1;
                // 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
                if(map[nr][nc] == 1) {
                    break;
                }
                // 바라보는 방향을 유지한 채로 한 칸 후진을 한다.
                else {
                    r = nr;
                    c = nc;
                }
                continue;
            }

            // !현재 위치, 현재 방향 기준!
            int checkDir = getLeftDirection(d);
            int nr = r + dr[checkDir];
            int nc = c + dc[checkDir];

            // 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 청소를 진행한다.
            // 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.
            if(!isCleaned[nr][nc] && map[nr][nc] == 0){
                d = checkDir;
                r = nr;
                c = nc;

                ++ans; // 청소 진행
                isCleaned[r][c] = true;
            }
            // 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전한다.
            else {
                d = checkDir;
            }
        }

        System.out.print(ans);
    }

    private static boolean isFinished(int r, int c, boolean[][] isCleaned){
        int cnt = 0;
        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(map[nr][nc] == 1 || isCleaned[nr][nc]) ++cnt;
        }

        // 4방향 모두 벽 또는 청소된 공간이면 true
        return (cnt==4);
    }

    private static int getLeftDirection(int d){
        return (d-1<0) ? 3 : d-1;
    }
}
