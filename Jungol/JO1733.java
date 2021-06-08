package Jungol;

import java.io.*;
import java.util.*;

public class JO1733 { // 8방탐색

    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Point> selected;

    static class Point implements Comparable<Point>{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Point o){
            if(this.y == o.y){ // 연속된 다섯 개의 바둑알이 세로로 놓인 경우
                return this.x - o.x; // 그 중 가장 위에 있는 것
            }
            return this.y - o.y; // 가장 왼쪽에 있는 바둑알
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[19][19];
        for(int i=0; i<19; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<19; j++){
                map[i][j] = stoi(st.nextToken());
            }
        }

        int[] dr = {-1,1,0,0,-1,1,-1,1}; // 상하좌우 , 좌대각선 , 우대각선 => 총 3세트로 오목이 만들어진다
        int[] dc = {0,0,-1,1,-1,1,1,-1};

        visited = new boolean[19][19];
        selected = new ArrayList<>();
        for(int i=0; i<19; i++){
            for(int j=0; j<19; j++){
                if(map[i][j]!=0){ // 바둑돌인 경우
                    for(int d=0; d<8; d+=2) { // 8방탐색 시작
                        selected.add(new Point(i, j));
                        visited[i][j] = true;

                        getOhmok(i, j, dr[d], dc[d], map[i][j]);
                        getOhmok(i, j, dr[d+1], dc[d+1], map[i][j]);

                        if(selected.size() == 5){ // 방문 다 했는데 오목이면
                            Collections.sort(selected);
                            System.out.println(map[i][j]);
                            System.out.printf("%d %d", selected.get(0).x+1, selected.get(0).y+1);
                            return; // 출력하고 프로그램 종료
                        }

                        visited[i][j] = false; // 방문 다 했는데 오목이 아니면
                        selected.clear(); // 재탐색을 위해 다시 되돌려둔다
                    }
                }
            }
        }
        System.out.print(0); // 다 했는데 오목이 없는 판이면 0 출력
    }

    private static void getOhmok(int x, int y, int dr, int dc, int color){
        int nx = x + dr;
        int ny = y + dc;
        if(nx>=0 && nx<19 && ny>=0 && ny<19){
            if(!visited[nx][ny] && map[nx][ny]==color){ // 방문하지 않았고 연속되는 돌을 가지고 있으면
                selected.add(new Point(nx, ny));
                visited[nx][ny] = true;
                getOhmok(nx, ny, dr, dc, color);
                visited[nx][ny] = false; // 다음 연산에서도 (nx, ny) 돌을 사용하기 위해, 방문이 끝나면 되돌린다 (백트랙킹)
            }
        }
    }

    private static int stoi(String str){
        return Integer.parseInt(str);
    }
}
