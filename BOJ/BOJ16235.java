package BOJ;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ16235 {

    static class Tree {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Tree(int age){
            pq.offer(age);
        }
    }
    static int N, M, K;
    static int[][] map, amount;
    static Tree[][] tree;
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, 1, -1, -1, 1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        map = new int[N+1][N+1];
        amount = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                map[i][j] = 5;
                amount[i][j] = sc.nextInt();
            }
        }
        tree = new Tree[N+1][N+1];
        for(int i=0; i<M; i++){
            tree[sc.nextInt()][sc.nextInt()] = new Tree(sc.nextInt());
        }

        simulation();
    }

    private static void simulation(){
        for(int year=1; year<=K; year++){
            // 봄, 여름
            ArrayList<int[]> spreadTree = springToSummer();
            // 가을
            fall(spreadTree);
            // 겨울
            winter();
        }

        System.out.print(getTreeCnt());
    }

    private static void winter(){
        // 땅에 양분을 추가한다.
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                map[i][j] += amount[i][j];
            }
        }
    }

    private static void fall(ArrayList<int[]> spreadTree){
        // 번식하는 나무는 나이가 5의 배수이어야 한다.
        for(int i=0, size=spreadTree.size(); i<size; i++){
            int r = spreadTree.get(i)[0];
            int c = spreadTree.get(i)[1];
            for(int d=0; d<8; d++){ // 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr>=1 && nr<=N && nc>=1 && nc<=N){
                    if(tree[nr][nc] == null)
                        tree[nr][nc] = new Tree(1);
                    else
                        tree[nr][nc].pq.offer(1);
                }
            }
        }
    }

    private static ArrayList<int[]> springToSummer(){
        ArrayList<int[]> spread = new ArrayList<>(); // 가을용
        ArrayList<int[]> dead = new ArrayList<>(); // 여름용
        for(int i=1; i<=N; i++){ // 봄 시작
            for(int j=1; j<=N; j++){
                if(tree[i][j] != null){
                    PriorityQueue<Integer> aliveTree = new PriorityQueue<>();
                    while(!tree[i][j].pq.isEmpty()){
                        int nowAge = tree[i][j].pq.poll();
                        if(map[i][j] >= nowAge) { // 봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다.
                            map[i][j] -= nowAge;
                            aliveTree.offer(nowAge+1);
                            if((nowAge+1)%5 == 0){ // 번식하는 나무는 나이가 5의 배수이어야 한다.
                                spread.add(new int[]{i, j});
                            }
                        }
                        else{ // 만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
                            dead.add(new int[]{i, j, nowAge});
                        }
                    }
                    tree[i][j].pq = aliveTree; // PriorityQueue 업데이트
                }
            }
        }
        addDeathTreeToLand(dead);// 여름
        return spread;
    }

    private static void addDeathTreeToLand(ArrayList<int[]> list){
        // 봄에 죽은 나무가 양분으로 변하게 된다.
        for (int[] info : list) {
            int r = info[0];
            int c = info[1];
            int age = info[2];
            map[r][c] += age / 2; // 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다.
        }
    }

    private static int getTreeCnt(){
        int cnt = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(tree[i][j] != null){
                    cnt += tree[i][j].pq.size();
                }
            }
        }
        return cnt;
    }
}
