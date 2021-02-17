package BOJ;

import java.io.*;
import java.util.*;

public class BOJ19621 {

    static int n, ans;
    static Meeting[] schedules;

    static class Meeting implements Comparable<Meeting>{
        int start, end, cnt;
        Meeting(int start, int end, int cnt){
            this.start = start;
            this.end = end;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Meeting o){
            if(this.end == o.end){
                return this.start-o.start;
            }
            return this.end-o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());
        schedules = new Meeting[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedules[i] = new Meeting(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()));
        }
        Arrays.sort(schedules);

        ans = 0;
        dfs(0, 0);
        System.out.print(ans);
    }

    private static void dfs(int cnt, int sum){
        if(cnt >= n){
            ans = Math.max(ans, sum);
            return;
        }

        // 임의의 회의 K(1≤ K ≤ N)는 회의 K − 1과 회의 K + 1과는 회의 시간이 겹치고 다른 회의들과는 회의 시간이 겹치지 않는다.
        dfs(cnt+2, sum+schedules[cnt].cnt); // 이번 회의 참가=> 이전/다음 회의와 시간 겹치므로 다음 회의 못감
        dfs(cnt+1, sum); // 이번 회의는 안감
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
