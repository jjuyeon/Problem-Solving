package BOJ;

import java.io.*;
import java.util.*;

public class BOJ15686_bitmask {

    static int n, m;
    static ArrayList<Pos> home, chicken;

    static class Pos {
        int x,y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                String value = st.nextToken();
                if(value.equals("1")) home.add(new Pos(i, j)); // 집 위치 저장
                else if (value.equals("2")) chicken.add(new Pos(i, j)); // 치킨집의 위치 저장
            }
        }

        int ans = Integer.MAX_VALUE;
        int size = 1<<chicken.size();
        for(int i=0; i<size; i++){
            if(getBitCnt(i) == m){ // i=> 뽑힌 치킨집 (한 가지 경우의 수)
                ans = Math.min(ans, minDistance(i));
            }
        }
        System.out.print(ans);
    }

    private static int minDistance(int bit){
        int min = 0;
        for(Pos h : home){ // 집을 기준으로 탐색
            int k = bit, idx = chicken.size()-1, dist = Integer.MAX_VALUE; // 현재 집에서 가장 가까운 치킨 집 고르기위한 세팅
            while(k > 0 && idx >= 0){
                if((k&1) == 1){ // 저장된 맨 뒤 치킨집부터 탐색
                    dist = Math.min(dist, getDistance(h, chicken.get(idx)));
                }
                k = k>>1; // 뒤부터 탐색하므로 앞으로 전진하도록 한다
                idx--;
            }
            min += dist;
        }
        return min;
    }

    private static int getDistance(Pos ho, Pos chick){
        return Math.abs(ho.x-chick.x) + Math.abs(ho.y-chick.y);
    }

    private static int getBitCnt(int bit){ // 비트에 저장된 '1'의 개수를 구한다
        int cnt = 0;
        while(bit > 0){
            cnt += bit&1;
            bit = bit>>1;
        }
        return cnt;
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
