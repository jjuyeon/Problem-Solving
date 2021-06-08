package BOJ;

import java.util.Scanner;

public class BOJ2846 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        int[] saveRoad = new int[N];
        int prev, roadStartIdx = 0, roadIdx = 0;
        for(int i=1; i<N; i++){
            prev = arr[i-1];
            if(prev >= arr[i]){ // 오르막길 아님
                saveRoad[roadIdx++] = prev - arr[roadStartIdx];
                roadStartIdx = i;
            }
        }
        // 배열의 마지막 위치에 오르막길 있는지 체크
        saveRoad[roadIdx++] = arr[N-1] - arr[roadStartIdx];

        int ans = 0;
        for(int i=0; i<roadIdx; i++){
            ans = Math.max(ans, saveRoad[i]);
        }
        System.out.println(ans);
    }
}
