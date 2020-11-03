import java.io.*;
import java.util.*;

public class BOJ1525 {
    final static int[][] direction = {{0,-1},{0,1},{1,0},{-1,0}}; // 순서: left, right, up, down
    static HashMap<Integer, Integer> map;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int start = 0;
        map = new HashMap<>();
        queue = new LinkedList<>(); // bfs를 위해서 필요한 자료구조

        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                int now = Integer.parseInt(st.nextToken());
                if(now == 0) now = 9;
                start = start * 10 + now;
            }
        }

        map.put(start, 0); // key: 퍼즐의 위치 의미, value: 이동 횟수를 의미
        queue.offer(start);

        System.out.print(bfs());
    }

    static int bfs(){
        while(!queue.isEmpty()){
            // 9의 위치를 찾기 위해 int -> string으로 바꿈
            int now_int = queue.poll();
            String now = String.valueOf(now_int);

            if(now_int == 123456789) return map.get(now_int); // 퍼즐이 완성된 경우(정렬)

            // 퍼즐이 완성되지 않았다면
            int idx_nine = now.indexOf("9"); // 9의 인덱스를 찾는다

            // 움직일 수 있는 모든 위치(최대 4가지 방향)에 대하여 탐색
            // 몫 연산: 행, 나머지 연산: 열
            int r = idx_nine / 3;
            int c = idx_nine % 3;

            for(int i=0; i<4; i++){
                int nr = r + direction[i][0];
                int nc = c + direction[i][1];
                if(nr<0 || nc<0 || nr>=3 || nc>=3) continue; // 범위를 벗어남

                // 움직인 위치 저장
                // r*3+c : 퍼즐의 1차원 배열에서 빈칸으로 바뀌는 위치
                // 이전 빈칸의 위치와 r*3+c의 위치를 바꾸자!
                int idx_next = nr*3 + nc;
                StringBuilder next = new StringBuilder(now);
                next.setCharAt(idx_nine, next.charAt(idx_next)); // 이전 빈칸 위치에 바꾼 숫자(idx_next에 있는 문자)로 변경
                next.setCharAt(idx_next, '9'); // 이동할 위치에 빈칸으로 변경

                int next_int = Integer.parseInt(next.toString());
                if(!map.containsKey(next_int)){ // 만약 hashmap에 없는 위치라면 업데이트 필요
                    map.put(next_int, map.get(now_int) + 1);
                    queue.offer(next_int);
                }
            }
        }
        return -1;
    }
}
