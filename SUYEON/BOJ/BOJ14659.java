package BOJ;

import java.util.Scanner;

public class BOJ14659 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        int ans = 0;
        for(int i=0; i<N-1; i++){ // 마지막은 해보나마나 0임
            int cnt = 0;
            for(int j=i+1; j<N; j++){ // 현재 위치의 다음 위치부터 끝까지 탐색
                if(arr[j] - arr[i] > 0){ // 다음 위치가 현재 위치보다 더 높으면
                    break; // 더 이상 갈 수없음 stop
                }
                ++cnt; // 낮으면 적을 처치할 수 있으므로, 카운팅
            }
            // 탐색 후, max값을 업데이트해준다
            ans = Math.max(ans, cnt);
        }

        System.out.print(ans);
    }
}
