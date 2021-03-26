package BOJ;

import java.util.*;

// https://steady-coding.tistory.com/97
public class BOJ9205_floyd {

    static class Pos {
        int x, y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static Pos[] map;
    static boolean[][] dist;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case=1; test_case<=T; test_case++){
            n = sc.nextInt();
            map = new Pos[n+2];
            for(int i=0; i<n+2; i++){
                map[i] = new Pos(sc.nextInt(), sc.nextInt());
            }

            dist = new boolean[n+2][n+2];
            for(int i=0; i<n+2; i++){
                for(int j=0; j<n+2; j++){
                    if(i!=j){
                        if(Math.abs(map[i].x-map[j].x) + Math.abs(map[i].y-map[j].y) <= 1000){ // 한번에 갈 수 있는 경우 체크
                            dist[i][j] = true;
                        }
                    }
                }
            }

            floyd();

            if(dist[0][n+1]){ // 시작점(0)과 끝점(n-1)이 이어져있는지 확인
                System.out.println("happy");
            }else{
                System.out.println("sad");
            }
        }
    }

    private static void floyd(){ // "경찰도"
        for(int k=0; k<n+2; k++){ // 경유지
            for(int i=0; i<n+2; i++){ // 출발지
                for(int j=0; j<n+2; j++){ // 도착지
                    if(i!=j && i!=k && j!=k){
                        if(dist[i][k] && dist[k][j]){ // 경유해서 갈 수 있는지도 체크
                            dist[i][j] = true;
                        }
                    }
                }
            }
        }
    }
}
