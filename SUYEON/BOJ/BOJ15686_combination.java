package BOJ;

import java.io.*;
import java.util.*;

public class BOJ15686_combination {

    static int n, m, ans;
    static ArrayList<Pos> chicken, home;

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
        chicken = new ArrayList<>();
        home = new ArrayList<>();
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                String value = st.nextToken();
                if(value.equals("1")) home.add(new Pos(i, j));
                if(value.equals("2")) chicken.add(new Pos(i, j));
            }
        }

        ans = Integer.MAX_VALUE;
        combination(0, 0, new Pos[m]);
        System.out.print(ans);
    }

    private static void combination(int start, int idx, Pos[] selected){
        if(idx == m){
            int sum = 0;
            for(int i=0; i<home.size(); i++){
                int nowMin = Integer.MAX_VALUE;
                for(int j=0; j<m; j++){
                    nowMin = Math.min(nowMin, getDistance(home.get(i), selected[j]));
                }
                sum += nowMin;
            }

            ans = Math.min(ans, sum);
            return;
        }

        for(int i=start, size=chicken.size(); i<size; i++){
            selected[idx] = chicken.get(i);
            combination(i+1, idx+1, selected);
        }
    }

    private static int getDistance(Pos p, Pos c){
        return Math.abs(p.x-c.x) + Math.abs(p.y-c.y);
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
