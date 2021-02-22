package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2304 {

    static class Stick {
        int x,y;
        Stick(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        Stick[] arr = new Stick[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken());
            int y = stoi(st.nextToken());
            arr[i] = new Stick(x, y);
        }
        Arrays.sort(arr, (o1, o2) -> o1.x - o2.x); // x를 기준으로 오름차순 정렬

        // max 기둥과 그 위치 찾기
        int max=0, maxIdx=0;
        for(int i=0; i<n; i++){
            if(max<arr[i].y){
                max = arr[i].y;
                maxIdx = i;
            }
        }

        int area = 0;

        // max 왼쪽 부분(앞에서부터 탐색)
        int nowHeight = arr[0].y, nowWidth = arr[0].x; // 0번째 인덱스 값부터 비교
        for(int i=1; i<=maxIdx; i++){
            if(nowHeight <= arr[i].y){ // 높이(y)가 더 큰 기둥 발견할 시, 업데이트
                area += (arr[i].x - nowWidth) * nowHeight;
                nowHeight = arr[i].y;
                nowWidth = arr[i].x;
            }
        }

        // max 기둥 더하기
        area += max;

        // max 오른쪽 부분(뒤에서부터 탐색)
        nowHeight = arr[n-1].y; nowWidth = arr[n-1].x; // 마지막(인덱스 n-1) 값부터 비교
        for(int i=n-2; i>=maxIdx; i--){
            if(nowHeight <= arr[i].y){ // 높이(y)가 더 큰 기둥 발견할 시, 업데이트
                area += (nowWidth - arr[i].x) * nowHeight; // 뒤에서부터 비교하므로 이전 x값이 더 큼
                nowHeight = arr[i].y;
                nowWidth = arr[i].x;
            }
        }
        System.out.println(area);
    }

    private static int stoi(String str){
        return Integer.parseInt(str);
    }
}
