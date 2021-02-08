package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class D3_1860 {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            int[] clients = new int[n];
            for(int i=0; i<n; i++){
                clients[i] = sc.nextInt();
            }
            Arrays.sort(clients); // 오름차순

            int time = 0, count = 0, idx = 0;
            for(idx=0; idx<n; idx++){ // 고객 수만큼 반복
                while(time != clients[idx]){ // 시간을 고객 도착 시간으로 맞춰줌
                    time++;
                    if(time % m == 0){ // 붕어빵 나올 시간이면 붕어빵을 더해줌
                        count += k;
                    }
                }

                if(count > 0){ // 고객 도착 시간에 붕어빵이 있다면
                    count--; // 붕어빵 하나 주고 붕어빵 개수 업데이트
                }else{ // 붕어빵이 없다면
                    break; // 미션 실패, 반복문을 끝내준다
                }
            }

            if(idx == n){ // 완벽하게 다 반복문을 다 돌았다면 성공
                sb.append("#").append(test_case).append(" ").append("Possible").append("\n");
            }else{ // 중간에 break 문을 만나 끝났다면 실패
                sb.append("#").append(test_case).append(" ").append("Impossible").append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
