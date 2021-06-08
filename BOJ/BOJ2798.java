package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2798 {
    static int N, M, ans = 0;
    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        cards = new int[N];
        for(int i=0; i<N; i++){
            cards[i] = stoi(st.nextToken());
        }

        for(int i=0; i<N; i++){ // 조합의 개념 적용
            combination(i, cards[i], 2); // i번째 값은 무조건 선택한다
        }

        System.out.print(ans);
    }

    static void combination(int nowCard, int sum, int r){
        if(r == 0){
            if(sum <= M){ // M보다 작거나 같으면 최대로 큰 값을 결과로 업데이트
                ans = Math.max(ans, sum);
            }
            return;
        }

        for(int i=nowCard+1; i<N; i++){ // i번째 이후의 값만 검사 (i번째 이전의 값은 이미 검사함)
            combination(i, sum+cards[i], r-1);
        }
    }

    static int stoi(String str){
        return Integer.parseInt(str);
    }
}
