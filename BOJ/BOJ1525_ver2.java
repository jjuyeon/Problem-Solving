package BOJ;

import java.util.*;

public class BOJ1525_ver2 {

    static class Node {
        int cnt;
        StringBuilder puzzle;

        Node(int cnt, StringBuilder puzzle) {
            this.cnt = cnt;
            this.puzzle = puzzle;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder puzzle = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String val = sc.next();
                puzzle.append(val);
            }
        }

        bfs(puzzle);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bfs(StringBuilder puzzle) {
        Set<String> set = new HashSet<>(); // 이전에 나온 값인지 체크하기 위해, 중복이 안되는 자료구조 set 사용
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(0, puzzle));
        set.add(puzzle.toString());

        int zero, changeZero, x, y, nx, ny;
        while(!queue.isEmpty()) {
            Node now = queue.poll();

            if(now.puzzle.toString().equals("123456780")) { // 퍼즐이 완성되었으면
                System.out.println(now.cnt); // 최소 이동 횟수 출력
                return;
            }

            zero = now.puzzle.indexOf("0"); // 빈칸의 인덱스 확인
            x = zero / 3;
            y = zero % 3; // x, y축 나누기

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if(nx<0 || nx>=3 || ny<0 || ny>=3){
                    continue;
                }

                changeZero = nx*3 + ny; // 동, 서, 남, 북의 인덱스 계산

                StringBuilder nowPuzzle = new StringBuilder(now.puzzle); // 새로운 퍼즐 구성
                nowPuzzle.setCharAt(zero, nowPuzzle.charAt(changeZero));
                nowPuzzle.setCharAt(changeZero, '0'); // 0의 위치와 변경

                if(!set.contains(nowPuzzle.toString())) { // 아직 만들어진 적이 없는 퍼즐이면
                    queue.offer(new Node(now.cnt + 1, nowPuzzle)); // 큐에 넣고
                    set.add(nowPuzzle.toString()); // set에 넣는다
                }
            }
        }
        // 여기까지 왔으면 퍼즐을 완성하지 못하는 것이다.
        System.out.println(-1);
    }
}
