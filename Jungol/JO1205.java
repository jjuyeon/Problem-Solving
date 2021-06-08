package Jungol;

import java.io.*;
import java.util.*;

public class JO1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int joker = 0; // 조커 몇개 있는지 확인
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int val = Integer.parseInt(st.nextToken());
            if(val == 0) ++joker;
            arr[i] = val;
        }
        Arrays.sort(arr);

        if(joker == n){ // 모두 다 조커라면 모두 다 스트레이트
            System.out.print(n);
            return;
        }

        int max = 0; // 정답
        for(int i=joker; i<n; i++){ // 실제 숫자가 저장된 공간부터 시작
            int jokerCnt = joker;
            int now = 1, prev = arr[i];

            for(int j=i+1; j<n; j++){ // 현재 숫자부터 끝까지 조커 사용하는 경우
                // 다음 수가 이전 수와 똑같음
                if(prev == arr[j]) continue;

                // 다음 수가 이전 수와 연속됨
                if(prev+1 == arr[j]){
                    ++prev;
                    ++now;
                    continue;
                }

                // 더 이상 조커가 없음(업데이트 불가)
                if(jokerCnt == 0) break;

                // 다음 수가 비연속적임 (한턴에 한개씩 조커를 사용한다)
                ++prev;
                ++now;
                --jokerCnt;
                --j; // 되돌리기 (왜? 아직 조커로 더 채워야하므로 이전 수로 계속 유지한다)
            }

            now += jokerCnt; // 남은 조커 뒤에 다 붙이기

            max = Math.max(max, now);
        }

        System.out.print(max);
    }

}
