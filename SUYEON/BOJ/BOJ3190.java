package BOJ;

import java.io.*;
import java.util.*;

public class BOJ3190 {

    static int[][] map;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = stoi(br.readLine());
        map = new int[n+1][n+1]; // 인덱스 1부터 시작

        // 사과가 있으면 1, 없으면 0
        int k = stoi(br.readLine());
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken());
            int y = stoi(st.nextToken());
            map[x][y] = 1; // 사과위치 저장
        }

        int l = stoi(br.readLine());
        int[] times = new int[l];
        String[] commands = new String[l];
        for(int i=0; i<l; i++){ // 뱀의 이동 방향이 바뀌는 시간, 방향 저장
            st = new StringTokenizer(br.readLine());
            times[i] = stoi(st.nextToken());
            commands[i] = st.nextToken();
        }

        int ans = bfs(times, commands, l);
        System.out.print(ans);
    }

    private static int bfs(int[] times, String[] commands, int len){
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int dir = 0, idx = 0;
        int time = 1;

        boolean[][] snake = new boolean[n+1][n+1]; // 현재 뱀의 위치 저장
        Queue<int[]> totalQueue = new LinkedList<>(); // bfs
        Queue<int[]> snakeQueue = new LinkedList<>(); // 뱀 꼬리 위치 저장
        totalQueue.offer(new int[]{1,1});
        snakeQueue.offer(new int[]{1,1});
        snake[1][1] = true;

        while(true){
            int[] now = totalQueue.poll();
            int x = now[0];
            int y = now[1];
            int nx = x + dr[dir];
            int ny = y + dc[dir];

            if(nx<1 || nx>n || ny<1 || ny>n || snake[nx][ny]){ // 벽 또는 자기자신의 몸과 부딪히면 게임이 끝난다
                break;
            }

            if(idx<len && times[idx] == time){ // 방향 변경 타임
                if(commands[idx].equals("L")){ // 왼쪽으로 방향 변경
                    if(dir==0) dir=4;
                    --dir;
                }
                else if(commands[idx].equals("D")){ // 오른쪽으로 방향 변경
                    dir = (dir+1)%4;
                }
                ++idx; // 변경 끝났으면 다음 방향 변경 타임을 기다림
            }

            // 뱀이 움직인다
            if(map[nx][ny] == 1) { // 사과 있는 곳을 지나면 사과가 없어짐
                map[nx][ny] = 0;
            }
            else { // 사과 없는 곳을 지나면 꼬리를 없앤다
                int[] remove = snakeQueue.poll();
                snake[remove[0]][remove[1]] = false;
            }

            snake[nx][ny] = true; // 머리 위치 업데이트
            snakeQueue.offer(new int[]{nx, ny}); // 이번 턴 뱀 꼬리 위치 저장
            totalQueue.offer(new int[]{nx, ny});
            ++time;
        }

        return time;
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
