package BOJ;

import java.util.Scanner;

public class BOJ21610 {

    static int N, M;
    static int[][] arr, cloudInfo;
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] dirInfo = new int[M][2];
        for (int i = 0; i < M; i++) {
            dirInfo[i][0] = sc.nextInt(); // d
            dirInfo[i][1] = sc.nextInt(); // s
        }

        cloudInfo = new int[N+1][N+1];
        cloudInfo[N][1] = 1; cloudInfo[N][2] = 1;
        cloudInfo[N-1][1] = 1; cloudInfo[N-1][2] = 1;

        simul(dirInfo);
    }

    private static void simul(int[][] dirInfo) {
        /*
        1. 모든 구름이 di 방향으로 si칸 이동한다.
        2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
        3. 구름이 모두 사라진다.
        4. 2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다.
        - 물복사버그 마법을 사용하면, 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다.
        - 이때는 이동과 다르게 경계를 넘어가는 칸은 대각선 방향으로 거리가 1인 칸이 아니다.
        5. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다.
           - 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
         */
        for (int i = 0; i < M; i++) {
            getCloudDir(dirInfo[i][0], dirInfo[i][1]);
            rain();
            bug();
            dry();
        }
        printAns();
    }

    private static void dry() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (cloudInfo[i][j]==0 && arr[i][j] >= 2) {
                    arr[i][j] -= 2;
                    cloudInfo[i][j] = 1;
                } else if(cloudInfo[i][j] == -1){
                    cloudInfo[i][j] = 0;
                }
            }
        }
    }

    private static void bug() {
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(cloudInfo[i][j] == 1){
                    int plus = 0;
                    for (int d = 1; d <= 4; d++) {
                        int nx = i + dx[2 * d];
                        int ny = j + dy[2 * d];
                        if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && arr[nx][ny] > 0) {
                            ++plus;
                        }
                    }
                    arr[i][j] += plus;
                    cloudInfo[i][j] = -1;
                }
            }
        }
    }

    private static void rain() {
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(cloudInfo[i][j] == 1){
                    ++arr[i][j];
                }
            }
        }
    }

    private static void getCloudDir(int dir, int jump) {
        int[][] temp = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(cloudInfo[i][j] == 1) {
                    int x = i;
                    int y = j;
                    for (int k = 1; k <= jump; k++) {
                        x = (x + dx[dir]) % N;
                        y = (y + dy[dir]) % N;
                        if (x == 0) {
                            x = N;
                        }
                        if (y == 0) {
                            y = N;
                        }
                    }
                    temp[x][y] = 1;
                }
            }
        }

        cloudInfo = temp;
    }

    private static void printAns(){
        int ans = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                ans += arr[i][j];
            }
        }
        System.out.print(ans);
    }
}
