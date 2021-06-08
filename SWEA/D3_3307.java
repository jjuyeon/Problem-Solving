package SWEA;

import java.util.*;

public class D3_3307 {
    public static void main(String[] args){ // O(n^2)
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt(); // 원소 개수
            int[] arr = new int[N]; // 원소들 저장
            // !!!!!!!동적테이블 정의내리는 게 제일 중요!!!!!!!
            int[] LIS = new int[N]; // 각 원소를 끝에 세웠을 때의 최장길이

            for(int i=0; i<N; i++) {
                arr[i] = sc.nextInt();
            }

            // 동적테이블에 저장되는 가장 큰 값을 찾아야한다
            int max = 0;

            for(int i=0; i<N; i++) {
                LIS[i] = 1; // 자기 혼자 세웠을 때의 길이(1)로 초기화
                for(int j=0; j<i; j++) { // 맨앞부터 자신의 직전 원소까지 비교해 나감
                    if(arr[j]<arr[i] && LIS[i]<LIS[j]+1) {
                        LIS[i] = LIS[j]+1;
                    }
                }
                if(max < LIS[i]) max = LIS[i];
            }

            System.out.println("#"+test_case+" "+max);
        }
    }
}
