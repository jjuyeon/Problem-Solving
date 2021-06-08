package Jungol;

import java.io.*;
import java.util.StringTokenizer;

// Study about 'sliding window'
public class JO2577 {

    static int N, d, k, c;
    static int[] sushiPlate, selectedSushi;

    public static void main(String[] args) throws IOException {
        // Scanner쓰면 시간초과 뜬다..! 그러타! SWEA가 아니다!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 접시 수
        d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        k = Integer.parseInt(st.nextToken()); // 최대 연속 접시 개수
        c = Integer.parseInt(st.nextToken()); // 쿠폰번호

        selectedSushi = new int[d+1];
        sushiPlate = new int[N];
        for(int i=0; i<N; i++){
            sushiPlate[i] = Integer.parseInt(br.readLine());
        }

        System.out.print(slide());
    }

    private static int slide(){
        int ans, cnt = 0;
        // 초기화(처음엔 그냥 k개 연속으로 뽑는다 - 아무 조건 없음)
        for(int i=0; i<k; i++){
            int addSushiNum = sushiPlate[i];
            if(selectedSushi[addSushiNum] == 0) ++cnt;
            ++selectedSushi[addSushiNum];
        }

        ans = cnt;

        // 하나씩 비교
        for(int i=1; i<N; i++){
            if(ans <= cnt){ // 업데이트 구간
                ans = cnt;
                if(selectedSushi[c] == 0) ++ans; // 아직 쿠폰 안썼다(그럼 써야쥥)
            }
            // 앞에 스시 종류는 지우기
            int deleteSushiNum = sushiPlate[i-1];
            --selectedSushi[deleteSushiNum];
            if(selectedSushi[deleteSushiNum] == 0) --cnt;

            // 뒤에 스시 종류는 추가하기
            // k번째 뒤부터 추가시키기 위해 지워지는 스시부터 k만큼 떨어져있는 스시 접시를 추가한다
            int addSushiNum = sushiPlate[(k + i-1)%N];
            if(selectedSushi[addSushiNum] == 0) ++cnt;
            ++selectedSushi[addSushiNum];
        }
        return ans;
    }
}
