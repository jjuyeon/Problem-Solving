package SWEA;

import java.util.PriorityQueue;
import java.util.Scanner;

public class D3_1860_queue {
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

            PriorityQueue<Integer> clients = new PriorityQueue<>();
            for(int i=0; i<n; i++){
                clients.offer(sc.nextInt());
            }

            int count = 0, time = 0;
            boolean isPossible = true;
            while(!clients.isEmpty()) {
                if(clients.peek() == time){ // 고객이 도착한 시간 중 최단 시간
                    if(count > 0){ // 이때 붕어빵이 있는 경우
                        count--; // 고객에게 붕어빵을 주고
                        clients.poll(); // 고객을 보낸다
                    }
                    else{ // 붕어빵을 지금 못사는 경우도 종료
                        isPossible = false; // 고객에게 붕어빵을 못줬으므로 실패
                        break;
                    }
                }
                else{ // 고객이 도착한 시간이 아니라면 계속 붕어빵을 만들기 위해 시간을 보낸다
                    time++;
                    /**
                     * 아래의 조건문을 else문 밖에 위치시켜 10번 넘게 틀렸다
                     * 만약 2초 당 1개의 붕어빵이 만들어지고 2초에 3명의 고객이 왔다면
                     * impossible이 되어야 하는데, 붕어빵의 개수가 업데이트 되는 조건문이 계속 호출되서
                     * 붕어빵을 3개 만들고 - 3명의 고객을 보내어 possible이 되었다..
                     * 그러므로 무조건 시간이 업데이트 될 때만 붕어빵 개수도 업데이트되도록 해야한다
                     */
                    if(time % m == 0){ // 시간이 업데이트 될 때만 붕어빵 개수도 업데이트된다..
                        count += k;
                    }
                }
            }

            if(isPossible){
                sb.append("#").append(test_case).append(" ").append("Possible").append("\n");
            }else{
                sb.append("#").append(test_case).append(" ").append("Impossible").append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
