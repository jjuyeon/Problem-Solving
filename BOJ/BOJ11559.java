package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11559 {

    static boolean isPop; // 여러 그룹이 터지더라도 한번의 연쇄가 추가된다
    static int answer;
    static char[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static class Pos {
        int r, c;
        Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        for(int i=0; i<12; i++){
            map[i] = br.readLine().toCharArray();
        }

        while(true) {
            isPop = false; // 한 턴에 한번의 연쇄만 인정되도록 사용하는 변수

            for (int i = 11; i >= 0; i--) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.') {
                        bfs(i, j, map[i][j]);
                    }
                }
            }
            if(!isPop) break; // 더이상 뿌요들을 못터뜨리는 상태이므로 끝낸다

            ++answer; // 여러 그룹이 터지더라도 한번의 연쇄가 추가되므로 +1
            updateMap(); // 터질 수 있는 뿌요가 여러 그룹이 있다면 동시에 터져야 한다
        }

        System.out.println(answer);
    }

    private static void bfs(int r, int c, char color){
        Stack<Pos> checkStack = new Stack<>(); // 4개 이상 상하좌우로 연결되어 있지 않다면 다시 되돌리기 위함(.->color)
        Queue<Pos> totalQueue = new LinkedList<>(); // bfs

        totalQueue.offer(new Pos(r, c)); // 시작 위치 큐에 저장
        map[r][c] = '.'; // 방문했음을 color -> .(빈칸)으로 체크한다

        int cnt = 1; // 상하좌우로 몇 개가 연결되어 있는지 체크한다
        while(!totalQueue.isEmpty()){
            Pos now = totalQueue.poll();
            checkStack.push(now); // 큐에서 하나씩 꺼낼 때마다 스택에 저장

            // 기존 bfs와 방식 동일
            for(int i=0; i<4; i++){
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if(nr<0 || nr>=12 || nc<0 || nc>=6) continue;

                if(map[nr][nc] == color){
                    totalQueue.offer(new Pos(nr, nc));
                    map[nr][nc] = '.';
                    ++cnt;
                }
            }
        }

        if(cnt >= 4){ // 4개이상 연결되어 있으면
            isPop = true; // 터뜨릴 수 있다고 체크하고
            checkStack.clear(); // 스택을 초기화해준다 (터뜨려서 .이 되므로 되돌릴 필요 없다)
        }
        else{
            while(!checkStack.isEmpty()) { // 스택에서 하나씩 꺼내서
                Pos revert = checkStack.pop();
                map[revert.r][revert.c] = color; // 기존 색으로 되돌린다
            }
        }
    }

    private static void updateMap(){
        Stack<Character> stack = new Stack<>();

        for(int j=0; j<6; j++){
            for(int i=0; i<12; i++){
                if(map[i][j] != '.'){ // 스택에 뿌요들을 다 저장함
                    stack.push(map[i][j]);
                }
            }

            int idx = 11;
            while(!stack.isEmpty()){ // 저장된 뿌요들을 맨 밑 바닥에 차례대로 넣고
                map[idx--][j] = stack.pop();
            }
            for(int i=0; i<=idx; i++){ // 나머지 윗 부분을 빈칸으로 채운다
                map[i][j] = '.';
            }
        }
    }
}
