package SWEA;

import java.util.Scanner;

/**
 * 8방탐색
 * 내가 간과한 점: 중간에 바둑돌이 없을 때는 바꿀 바둑돌이 없는 경우인데 이를 생각 못함
 * 그저 똑같은 바둑돌을 찾을 때까지 계속 반복시켜서 그 갯수만큼 바둑돌을 바꿔줌
 * 실제 코딩테스트였으면 틀렸다 ㅠ 여러 케이스의 personal test case를 만들어 더블체크하고 제출하자!
 * <코딩 습관 만들기>
 *     1) 내가 무엇을 구조, 아이디어를 정리
 *     2) 필요한 테스트 케이스를 구현 전에 미리 생각한다
 *     3) 그 다음에 직접 코딩으로 구현한다
 *     4) personal 테스트 케이스까지 돌려보면서 더블체크한다
 */
public class D3_4615 {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] game = makeSet(N, N/2 - 1);

            for(int i=0; i<M; i++){
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                int stone = sc.nextInt();

                game[x][y] = stone;
                changeStone(game, N, x, y, stone);
            }

            int black = 0, white = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(game[i][j] == 1){
                        black++;
                    }
                    else if(game[i][j] == 2){
                        white++;
                    }
                }
            }

            sb.append("#").append(test_case).append(" ").append(black).append(" ").append(white).append("\n");
        }

        System.out.print(sb.toString());
    }

    static int[][] changeStone(int[][] game, int size, int x, int y, int findStone){
        int[] dx = {-1,-1,-1,0,1,1,1,0}, dy = {-1,0,1,1,1,0,-1,-1};

        for(int i=0; i<8; i++){
            int count = 0;
            boolean isFind = false;

            int nx = x + dx[i];
            int ny = y + dy[i];
            while(nx>=0 && nx<size && ny>=0 && ny<size){
                if(game[nx][ny] == 0){ // !!!중간에 바둑돌이 없을 때!!!
                    break;
                }
                if(game[nx][ny] == findStone){
                    isFind = true;
                    break;
                }
                nx += dx[i];
                ny += dy[i];
                count++;
            }

            if(isFind){
                nx = x; ny = y;
                while(count>0){
                    nx += dx[i];
                    ny += dy[i];
                    game[nx][ny] = findStone;
                    count--;
                }
            }
        }
        return game;
    }

    static int[][] makeSet(int size, int startIdx){
        int[][] game = new int[size][size];
        // 1: 흑돌, 2: 백돌
        game[startIdx][startIdx] = 2;
        game[startIdx][startIdx+1] = 1;
        game[startIdx+1][startIdx] = 1;
        game[startIdx+1][startIdx+1] = 2;

        return game;
    }
}
