package SWEA;

import java.util.Scanner;

public class SW_5644 {

    static int[] dr = {0, -1, 0, 1, 0};
    static int[] dc = {0, 0, 1, 0, -1};

    static class Charger{
        int x, y, c, p;
        public Charger(int y, int x, int c, int p){
            this.y = y; // y좌표
            this.x = x; // x좌표
            this.c = c; // 충전범위
            this.p = p; // 성능(처리량)
        }
    }

    static class User{
        int x, y;
        public User(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int M = sc.nextInt(); // 총 이동 시간
            int A = sc.nextInt(); // BC 개수

            int[] da = new int[M+1];
            int[] db = new int[M+1];
            da[0] = 0; db[0] = 0;
            for(int i=1; i<=M; i++){
                da[i] = sc.nextInt();
            }
            for(int i=1; i<=M; i++){
                db[i] = sc.nextInt();
            }

            Charger[] chargers = new Charger[A];
            for(int i=0; i<A; i++){
                chargers[i] = new Charger(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            }
            System.out.println("#"+test_case+" "+simul(M, da, db, A, chargers));
        }
    }

    private static int simul(int M, int[] da, int[] db, int A, Charger[] chargers){
        int ans = 0;
        User a = new User(1, 1);
        User b = new User(10, 10);

        for(int time=0; time<=M; time++){
            // 이동
            a.x += dr[da[time]]; a.y += dc[da[time]];
            b.x += dr[db[time]]; b.y += dc[db[time]];

            int max = 0;
            for(int i=0; i<A; i++){
                int aIdx = -1; // 초기값이 서로 안겹치게 하기 위함(dummy값)
                if(getDistance(a.x, a.y, chargers[i].x, chargers[i].y) <= chargers[i].c) aIdx = i;

                for(int j=0; j<A; j++){
                    int bIdx = -1; // 초기값이 서로 안겹치게 하기 위함(dummy값)
                    if(getDistance(b.x, b.y, chargers[j].x, chargers[j].y) <= chargers[j].c) bIdx = j;

                    if(aIdx == -1 && bIdx == -1) continue;
                    if(aIdx == -1) max = Math.max(max, chargers[bIdx].p);
                    else if(bIdx == -1) max = Math.max(max, chargers[aIdx].p);
                    else if(aIdx == bIdx) max = Math.max(max, chargers[aIdx].p);
                    else max = Math.max(max, chargers[aIdx].p+chargers[bIdx].p);
                }
            }
            ans += max;
        }

        return ans;
    }

    private static int getDistance(int x1, int y1, int x2, int y2){
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
}
