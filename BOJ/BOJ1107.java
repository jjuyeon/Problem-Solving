package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1107 {

    static int n, m;
    static StringBuilder broken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        broken = new StringBuilder();

        if(m>0) { // 고장난 버튼이 있을 때만 input을 받음
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                broken.append(st.nextToken());
            }
        }
        bruteForce();
    }

    private static void bruteForce(){
        int leftChannel = findChannel(true); // n과 가장 근접하면서 작은 채널 구함
        int rightChannel = findChannel(false); // n과 가장 근접하면서 큰 채널 구함

        int ans = Math.abs(100-n); // 시작채널 100에서 +,- 만을 이용해서 n으로 가는 경우
        if(leftChannel != -1){ // 작은 채널을 찾았다면, 작은 채널에서 n으로 가는 횟수와 비교하여 최소 횟수 업데이트
            ans = Math.min(ans, n - leftChannel + Integer.toString(leftChannel).length());
        }
        if(rightChannel != -1){ // 큰 채널을 찾았다면, 큰 채널에서 n으로 가는 횟수와 비교하여 최소 횟수 업데이트
            ans = Math.min(ans, rightChannel - n + Integer.toString(rightChannel).length());
        }
        System.out.print(ans);
    }

    private static int findChannel(boolean isLeft){
        int result = n;
        if(isLeft){
            while(result>=0){ // 리모컨으로 누를 수 있는 최소 값 0
                if(!checkBrokenButton(result)){
                    return result;
                }
                --result;
            }
        }
        else{
            while(result<=999999){ // 리모컨으로 누를 수 있는 최대 값 999,999
                if(!checkBrokenButton(result)){
                    return result;
                }
                ++result;
            }
        }
        return -1;
    }
    private static boolean checkBrokenButton(int channel){
        if(channel==0 && broken.toString().contains("0")){ // while문은 0은 체크를 못해주므로 따로 빼서 체크해준다
            return true;
        }
        while(channel > 0){
            if(broken.toString().contains(Integer.toString(channel%10))){ // 1의 자리부터 체크해서 고장난 버튼이 있으면 true
                return true;
            }
            channel /= 10; // 밑 한 자리씩 버리면서 모든 자릿수를 체크한다
        }

        return false; // 다 탐색했는데 고장난 버튼을 찾지못하면 여기는 고장난 버튼이 없으므로 숫자만으로 입력 가능한 채널이다
    }
}
