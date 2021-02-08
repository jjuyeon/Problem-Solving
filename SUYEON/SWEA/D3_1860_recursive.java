package SWEA;

import java.util.Arrays;
import java.io.*;
import java.util.StringTokenizer;

public class D3_1860_recursive {

    static int n, m, k;
    static int[] clients;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = stoi(st.nextToken());
            m = stoi(st.nextToken());
            k = stoi(st.nextToken());

            clients = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                clients[i] = stoi(st.nextToken());
            }
            Arrays.sort(clients); // 오름차순

            boolean isPossible = recursive(0, 0, 0);
            if(isPossible){
                sb.append("#").append(test_case).append(" ").append("Possible").append("\n");
            }else{
                sb.append("#").append(test_case).append(" ").append("Impossible").append("\n");
            }
        }

        System.out.print(sb.toString());
    }

    /**
     * client가 도착하는 시간은 0~11111이다.
     * 그래서 client의 도착 시간을 기저조건으로 한다면
     * 1000개 케이스에 대하여 각각 정렬과 최대 11111번(시간)을 반복을 하기 때문에
     * Runtime error가 뜰 수 밖에 없다
     *
     * 이 문제에서 시간초과를 피하려면 정렬 이후 시간을 통해 계산 하는 것이 아니라,
     * 사람숫자(100이내)의 시간을 계산하여 현재까지의 사람 숫자만큼 붕어빵이 만들어져있는가를 확인하면 된다.
     */
    static boolean recursive(int time, int idx, int count){
        while(time == clients[idx]){ // 동일 시간에 도착한 손님들 다 처리해줌
            if(count <= 0){
                return false;
            }

            idx++;
            count--;

            if(idx == n){
                return true;
            }
        }

        /**
         * 단항 연산자를 쓰면 Runtime error
         * 이유: 증감 연산자가 매개변수로 값을 넘기는 것보다 3배정도 느리다
         */
//        time++;
        if(time != 0 && time % m == 0){
            count += k;
        }

        return recursive(time+1, idx, count);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
