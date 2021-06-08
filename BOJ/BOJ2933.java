package BOJ;

import java.util.*;

public class BOJ2933 {

    static int r, c;
    static char[][] map;
    static boolean[][] v;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        r = stoi(sc.next());
        c = stoi(sc.next());

        map = new char[r+1][c+1];
        for(int i=r; i>=1; i--){
            String str = sc.next();
            for(int j=1; j<=c; j++){
                map[i][j] = str.charAt(j-1);
            }
        }

        int n = stoi(sc.next());
        int[] stick = new int[n];
        for(int i=0; i<n; i++){
            stick[i] = stoi(sc.next());
        }

        simulation(stick, n);
        printAns();
    }

    private static void simulation(int[] stick, int n){
        boolean left = true;

        for(int i=0; i<n; i++){
            int height = stick[i]; // 미네랄이 파괴된 높이(행)
            int width = throwStick(height, left); // 미네랄이 파괴된 열을 반환한다

            if(width>0){ // 미네랄 파괴했다면
                for(int d=0; d<4; d++){ // 상하좌우로 체크
                    int nr = height + dr[d];
                    int nc = width + dc[d];
                    if(nr<=0 || nr>r || nc<=0 || nc>c || map[nr][nc]!='x') continue; // 범위에서 벗어나거나 미네랄이 아니면 패스
                    if(bfs(nr, nc)){ // 새롭게 생성된 클러스터가 떠 있는 경우 체크
                        fall(); // 중력에 의해서 바닥으로 떨어지게 된다
                    }
                }
            }
            left = !left; // 왼쪽/오른쪽 번갈아가면서 막대기를 던지기 위해 로테이션
        }
    }

    private static int throwStick(int height, boolean left){ // 막대기 던지는 함수
        int idx;
        if(left){ // 왼쪽에서 던질 때
            for(idx=1; idx<=c; idx++){
                if(map[height][idx] == 'x'){
                    map[height][idx] = '.';
                    break;
                }
            }
        }
        else{ // 오른쪽에서 던질 때
            for(idx=c; idx>=1; idx--){
                if(map[height][idx] == 'x'){
                    map[height][idx] = '.';
                    break;
                }
            }
        }
        return idx; // 막대기를 던져 미네랄이 파괴된 열의 인덱스
    }

    private static boolean bfs(int sr, int sc){
        v = new boolean[r+1][c+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        v[sr][sc] = true; // 시작 지점부터 시작

        boolean isFall = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll(); //[0]: 행, [1]: 열
            if(now[0] == 1){ // 바닥까지 도착한다면 중력에 의해서 바닥에 떨어질 미네랄이 없음
                isFall = false;
                break;
            }
            for(int i=0; i<4; i++){
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if(nr<=0 || nr>r || nc<=0 || nc>c ||v[nr][nc]) continue;
                if(map[nr][nc] == 'x'){
                    queue.offer(new int[]{nr, nc});
                    v[nr][nc] = true;
                }
            }
        }
        return isFall;
    }

    private static void fall(){
        // v배열의 true 부분은 새롭게 생성된 클러스터가 떠 있는 상태

        // 최소 gap 구하기
        int gap = Integer.MAX_VALUE;
        for(int j=1; j<=c; j++){
            for(int i=2; i<=r; i++){
                if(v[i][j] && map[i-1][j]=='.'){ // 현재 클러스터 영역이고, 밑으로 떨어질 수 있다면(밑이 x이면 떨어질 수 없음)
                    gap = Math.min(gap, getFallingGap(i, j)); // gap을 구해, 최소 gap으로 업데이트한다
                }
            }
        }

        // 최소 gap만큼 내리기
        if(gap>0) { // gap이 있을 때만 진행
            for (int j = 1; j <= c; j++) {
                for (int i = 2; i <= r; i++) {
                    if (v[i][j]) { // 클러스터 영역이면
                        map[i - gap][j] = 'x'; // gap만큼 내려준다
                        map[i][j] = '.'; // 원래 위치는 x->.으로 되돌린다
                    }
                }
            }
        }
    }

    private static int getFallingGap(int sr, int sc){ // gap 구하기 함수
        int height = sr-1; // 검사 위치 밑줄부터 시작한다
        for( ; height>=1; height--){
            if(!v[height][sc] && map[height][sc] == 'x'){ // 클러스터 영역이 아니고, 현재 영역이 x이면 -> 다른 미네랄 영역이므로
                break; // 더이상 내려갈 수 없다
            }
        }
        return sr-(height+1); // gap 계산하여 리턴
    }

    private static void printAns(){ // 정답 출력 함수
        for(int i=r; i>=1; i--){
            for(int j=1; j<=c; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static int stoi(String str){
        return Integer.parseInt(str);
    }
}
