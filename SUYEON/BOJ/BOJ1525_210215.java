package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1525_210215 {

    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int puzzle = 0;
        for(int i=0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                int now = Integer.parseInt(st.nextToken());
                if(now == 0) now = 9;
                puzzle = puzzle * 10 + now;
            }
        }
        bfs(Integer.toString(puzzle));
        System.out.print(ans);
    }

    /*
    //  이렇게 하면 4번 칸과 3번 칸, 7번 칸과 6번 칸을 교환할 수 없으나 이렇게 하면 갈 수 있게 만들어짐
    static int[] dir = {-3, 3, -1, 1}; // 상하좌우
    */
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1};
    private static void bfs(String start){
        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> visited = new HashMap<>();
        queue.offer(start);
        visited.put(start, 0);

        while(!queue.isEmpty()){
            String now = queue.poll();
            if(now.equals("123456789")){
                ans = visited.get(now);
                break;
            }

            int nowIdx = now.indexOf("9");
            int nowR = nowIdx/3;
            int nowC = nowIdx%3;

            for(int i=0; i<4; i++){
                int nextR = nowR + dr[i];
                int nextC = nowC + dc[i];

                if(nextR>=0 && nextR<3 && nextC>=0 && nextC<3){
                    int nextIdx = nextR*3 + nextC;
                    StringBuilder next = new StringBuilder(now);
                    next.setCharAt(nowIdx, now.charAt(nextIdx));
                    next.setCharAt(nextIdx, '9');

                    if(!visited.containsKey(next.toString())){
                        visited.put(next.toString(), visited.get(now) + 1);
                        queue.offer(next.toString());
                    }
                }
            }
        }
    }
}
