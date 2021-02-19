package BOJ;

import java.io.*;
import java.util.*;

public class BOJ17135 {

    static int n,m,d, ans;
    static ArrayList<Pos> enemy;
    static Pos[] archer;

    static class Pos implements Comparable<Pos> {
        int x,y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pos o){
            if(this.x == o.x){
                return this.y-o.y;
            }
            return o.x-this.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        d = stoi(st.nextToken());

        archer = new Pos[3];
        enemy = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                if(st.nextToken().equals("1")){
                    enemy.add(new Pos(i, j));
                }
            }
        }
        Collections.sort(enemy); // 정렬

        ans = 0;
        setArcherPos(0, 0); // 조합
        System.out.print(ans);
    }

    private static int playGame(ArrayList<Pos> list){
        int cnt = 0;
        while(!list.isEmpty()){
            HashSet<Pos> removeSet = new HashSet<>(); // 이번 경우의 수에서 공격받을 적의 위치를 저장(중복 저장 불가)
            for(int a=0; a<3; a++){
                Pos nowArcher = archer[a];
                Pos minEnemy = null;
                int minDist = 100; // 최대값
                for (Pos nowEnemy : list) {
                    int nowDist = getDistance(nowArcher, nowEnemy); // 거리 구하기
                    if(nowDist<=d){ // 궁수가 공격할 수 있는 적은 거리가 d이하인 적
                        if(nowDist<minDist){ // 궁수가 공격하는 적은 거리가 d이하인 적 중에서 가장 가까운 적이다.
                            minDist = nowDist;
                            minEnemy = nowEnemy;
                        }
                        else if(nowDist==minDist){ // 가장 가까운 적이 여럿일 경우에는 가장 왼쪽에 있는 적을 공격한다.
                            if(nowEnemy.y < minEnemy.y){
                                minEnemy =nowEnemy;
                            }
                        }
                    }
                }
                if(minEnemy!=null) { // minEnemy가 null이면 공격할 수 있는 적이 없다는 뜻
                    removeSet.add(minEnemy);
                }
            }

            cnt+=removeSet.size(); // 현재 궁수에게 공격받는 적의 수 업데이트
            for (Pos removeEnemy : removeSet) { // 현재 궁수에게 공격받은 적은 지워준다
                list.remove(removeEnemy);
            }

            int check = list.size(); // 남아있는 적의 수(이만큼만 체크하면 됨)
            while(check>0){ // 원래 있던 적의 위치를 업데이트
                Pos downEnemy = list.remove(0);
                if(downEnemy.x+1 < n){ // 범위 벗어나면 비교 리스트에서 지워줌(업데이트안해줌)
                    list.add(new Pos(downEnemy.x+1, downEnemy.y)); // 적의 위치를 밑으로 내려줌
                }
                --check;
            }
        }

        return cnt;
    }

    private static void setArcherPos(int start, int idx){
        if(idx == 3){
            int cnt = playGame(new ArrayList<>(enemy)); // 깊은 복사 사용
            ans = Math.max(ans, cnt); // '현재 경우의 수에서 공격한 적'과 비교하여 '적의 최대 수를 업데이트'
            return;
        }
        for(int i=start; i<m; i++){
            archer[idx] = new Pos(n, i);
            setArcherPos(i+1, idx+1);
        }
    }

    private static int getDistance(Pos a, Pos b){
        return Math.abs(a.x-b.x) + Math.abs(a.y-b.y);
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
