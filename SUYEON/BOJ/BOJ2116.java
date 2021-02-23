package BOJ;

import java.io.*;
import java.util.*;

/**
 * 처음에는 모든 경우의 수를 다 구하는 방식으로 구현했다(permutation)
 * 그랬더니 시간초과 에러가 떴다.. 당연한 결과였다 주사위의 개수가 10000개까지 들어오는데
 * 주사위 개수 10000개가 들어왔을 때, 모든 경우의 수를 다 구하려면 연산량이 10000!*6*6 이므로 2초가 넘어가버린다 (1억번 연산 = 약 1초)
 *
 * 1) 맨 밑 알파벳을 고르는 경우(6번 반복)
 * 2) 붙어 있는 면 = 같은 숫자를 가짐 -> 이 면을 찾는 경우(6번 반복)
 * 3) 붙어 있는 면과 그 짝을 제외하고 제일 큰 숫자를 가진 면을 찾는 경우(6번 반복)
 * 4) 가장 큰 숫자를 가진 면만 가지고 다음 주사위로 넘기면 되므로, 주사위 수만큼만 반복하면 됨(n번 반복)
 * 1), 2), 3), 4)의 방식으로 연산량을 훨씬 많이 줄일 수 있었다.
 */

public class BOJ2116 {

    static int n, ans;
    static int[] pair = {5,3,4,1,2,0}; // A-F , B-D, C-E
    static int[][] dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dice = new int[n][6];
        for(int i=0; i<n; i++){ // A=0, B=1, C=2, D=3, E=4, F=5
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<6; j++){
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        for(int alpha=0; alpha<6; alpha++){ // 맨 밑에 깔릴 알파벳 고름
            permutation(0, 0, dice[0][pair[alpha]]);
        }
        System.out.print(ans);
    }

    private static void permutation(int idx, int sum, int sameNum) {
        if (idx == n) {
            ans = Math.max(ans, sum);
            return;
        }

        boolean[] visited = new boolean[6];

        for (int j = 0; j < 6; j++) {
            if (sameNum == dice[idx][j]) {
                sameNum = dice[idx][pair[j]];
                visited[j] = true;
                visited[pair[j]] = true;
                break;
            }
        }
        int max = 0;
        for (int j = 0; j < 6; j++) {
            if (!visited[j]) {
                max = Math.max(max, dice[idx][j]);
            }
        }

        permutation(idx + 1, sum + max, sameNum);
    }
}
