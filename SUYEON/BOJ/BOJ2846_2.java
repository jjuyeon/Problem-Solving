package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2846_2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 수열의 크기

        // 입력받은 높이 저장
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오르막길인지 탐색
        // 가장 크기가 큰 오르막길 저장
        int max = 0;
        int startIdx = -1; // 오르막길 시작 index
        int endIdx = 0; // 오르막길 끝 index
        for (int i = 0; i < N - 1; i++) {
            if(arr[i] < arr[i + 1]) { // 오르막길인 경우
                if(startIdx == -1) // 오르막길 시작점인 경우
                    startIdx = i;
                endIdx = i + 1;
            } else { // 오르막길이 끝난 경우
                if(startIdx != -1) // 오르막길이 있으면
                    max = Integer.max(max, arr[endIdx] - arr[startIdx]); // 가장 높은 오르막길 저장
                startIdx = -1;
                endIdx = 0;
            }
        }
        if(startIdx != -1) // 마지막 오르막길이 있는 경우
            max = Integer.max(max, arr[endIdx] - arr[startIdx]);
        System.out.println(max);
    }
}
