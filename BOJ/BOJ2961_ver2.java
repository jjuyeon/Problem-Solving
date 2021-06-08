package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2961_ver2 {
    static long ans;
    static int N;
    static int[] S, B, flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        S = new int[N];
        B = new int[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = stoi(st.nextToken());
            B[i] = stoi(st.nextToken());
        }

        ans = Long.MAX_VALUE;
        for(int R=1; R<=N; R++){ // 1개 뽑는 경우 ~ N개(전부 다) 뽑는 경우까지 구함
            flag = new int[N];
            int cnt = 0;
            while(++cnt <= R) flag[N-cnt] = 1; // R만큼 flag 초기화

            do{
                long sum = 0, mul = 1;
                for(int i=0; i<N; i++) {
                    if(flag[i] == 1){
                        sum += B[i];
                        mul *= S[i];
                    }
                }
                ans = Math.min(ans, Math.abs(mul-sum));
            }while(np());
        }

        System.out.print(ans);
    }

    private static boolean np(){
        // STEP 1 : 꼭대기 찾기
        int i = N-1; // 꼭대기 찾기(i가 꼭대기임)
        while(i>0 && flag[i-1]>=flag[i]){
            i--;
        }

        // 꼭대기가 맨 앞이면 가장 큰 수까지 온 것(뒤에 만들 경우의 수 없음)
        if(i == 0){
            return false;
        }

        // STEP 2 : 꼭대기 전(i-1) 값과 서로 교환할 값 찾기
        int j = N-1;
        while(flag[i-1] >= flag[j]){ // i-1보다 큰 값 찾을 때까지 반복(j에는 i-1보다 한 단계 큰 값 = 바로 큰 수)
            j--;
        }

        // STEP 3 : 교환
        swap(i-1, j);

        // STEP 4 : 꼭대기부터 뒤의 끝까지 오름차순으로 바꿔주기
        int k = N-1;
        while(i<k){
            swap(i, k);
            i++; k--;
        }

        return true;
    }

    private static void swap(int i, int j){
        int temp = flag[i];
        flag[i] = flag[j];
        flag[j] = temp;
    }

    private static int stoi(String str){
        return Integer.parseInt(str);
    }
}
