package BOJ;

import java.util.*;

public class BOJ1339 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        // '어느 자릿수에서 + 어떤 알파벳이 +몇번 나왔는지' 저장
        int[] alphaToNumber = new int[26];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            int idx = 0;
            for (int j = str.length() - 1; j >= 0; j--) {
                // 인덱스값: 알파벳 저장
                // 배열 값: 해당 알파벳이 나온 자릿수 누적 저장
                alphaToNumber[str.charAt(j)-'A'] += Math.pow(10, idx);
                ++idx;
            }
        }
        Arrays.sort(alphaToNumber); // 정렬
        int ans = 0, num = 9;
        for(int i=25; i>=0; i--){ // 저장되어 있는 값이 가장 큰 것부터 높은 숫자 부여
            if(alphaToNumber[i] == 0) break;
            ans += num * alphaToNumber[i];
            --num;
        }
        System.out.print(ans);
    }
}
