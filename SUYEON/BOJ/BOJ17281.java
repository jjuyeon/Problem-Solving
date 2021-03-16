package BOJ;

import java.io.*;
import java.util.*;

public class BOJ17281 {

    static int[] orders;
    static boolean[] game;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());

        int[][] results = new int[n+1][10]; // i=1부터 시작, j=1부터 시작
        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=9; j++){
                results[i][j] = stoi(st.nextToken());
            }
        }

        int ans = 0;
        orders = new int[]{2,3,4,5,6,7,8,9}; // 4번타자는 항상 고정되어 있음 -> 1번 선수(그러므로 1번을 제외하고 순열을 돌림)

        do{
            // 모든 이닝 다 돌아서 합을 구함
            int idx = 0;
            int[] completeOrder = new int[9]; // 이 배열을 사용하여 점수를 구한다
            for(int i=0; i<9; i++){
                if(i == 3){ // 항상 4번 타자가 1번 선수가 되도록 순서를 확정지어줌
                    completeOrder[i] = 1;
                }
                else {
                    completeOrder[i] = orders[idx++];
                }
            }

            int sum = getScores(completeOrder, results, n);
            ans = Math.max(ans, sum); // 최대 값 업데이트
        }while(np()); // next-permutation을 통해, 타자의 순서를 정한다(각 타자의 점수가 아니라, 각 타자 넘버를 기준으로 경우의 수를 구함)

        System.out.print(ans);
    }

    private static int getScores(int[] completeOrder, int[][] results, int n){
        int sum = 0;
        int inning = 1, now = 0, outCnt = 0; // 초기값 설정
        game = new boolean[3];

        while(inning <= n){
            int nowScore = results[inning][completeOrder[now]];

            if(nowScore == 0) { // 아웃
                ++outCnt;
            }
            else {
                sum += move(nowScore); // 1: 안타, 2: 2루타, 3:3루타, 4:홈런
            }

            now = (now+1) % 9; // 1-9번 선수가 로테이션되도록 함

            if(outCnt == 3){ // 3아웃은 이닝 종료
                ++inning; // 다음 이닝으로 간다
                outCnt = 0; // 다음 이닝으로 가니까 카운트도 초기화
                Arrays.fill(game, false); // 주자도 초기화
            }
        }

        return sum;
    }

    private static int move(int score){
        int sum = 0;
        if(score == 4){ // 홈런
            if(game[0]) ++sum;
            if(game[1]) ++sum;
            if(game[2]) ++sum;
            ++sum; // 타자 자신도 홈으로 들어가므로
            Arrays.fill(game, false);
        }
        else if(score == 3){ // 3루타
            if(game[0]){
                ++sum;
                game[0] = false;
            }
            if(game[1]){
                ++sum;
                game[1] = false;
            }
            if(game[2]){
                ++sum;
            }
            game[2] = true;
        }
        else if(score == 2){ // 2루타
            if(game[2]){
                ++sum;
                game[2] = false;
            }
            if(game[1]){
                ++sum;
                game[1] = false;
            }
            if(game[0]){
                game[0] = false;
                game[2] = true;
            }
            game[1] = true;
        }
        else if(score == 1){ // 안타
            if(game[2]){
                ++sum;
                game[2] = false;
            }
            if(game[1]){
                game[1] = false;
                game[2] = true;
            }
            if(game[0]){
                game[1] = true;
            }
            game[0] = true;
        }

        return sum;
    }

    private static boolean np(){
        // 가장 큰 내림차순 순열을 만들 때까지 반복한다.

        // step 1 꼭대기 찾기
        int i = 7;
        while(i>0 && orders[i-1]>=orders[i]){
            --i;
        }
        if(i == 0){ // 앞에 자신보다 큰 수가 없다는 뜻 = 가장 큰 내림차순 순열
            return false; // 더이상 찾을 수 있는 것이 없음
        }

        // step 2 꼭대기 왼쪽에 꺾이는 위치와 교환할 큰 값 위치 찾기 (왜? 꼭대기부터 끝까지는 아무리 바꿔도 더 높은 수가 나올 수 없다)
        int j = 7;
        while(orders[i-1] >= orders[j]){
            --j; // 꼭대기 다음에 꺾이는 부분(i-1)보다 직전에 작은 위치 찾는다
        }

        // step 3 i-1과 j 값을 교환한다
        swap(i-1, j);

        // step 4 바뀐 자릿수가 커졌으므로, 바뀐 위치 뒤의 크기도 오름차순되어 있지 않다. 그러므로, 오름차순이 되도록 바꿔줘야함
        int k = 7;
        while(i<k){
            swap(i, k);
            ++i; --k;
        }

        return true;
    }

    private static void swap(int i, int k){
        int temp = orders[i];
        orders[i] = orders[k];
        orders[k] = temp;
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
