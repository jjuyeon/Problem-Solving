package Jungol;

import java.util.*;

public class JO1205_ver2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int joker = 0, max = 0;
        boolean[] arr = new boolean[10000001];
        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            if(num==0) ++joker;
            else arr[num] = true;

            max = Math.max(max, num);
        }

        Queue<Integer> used = new LinkedList<>();
        int ans = 0, len = 0;
        for(int i=1; i<=max+joker; i++){ // 맨 뒤에 조커가 다 몰리는 경우까지 생각하여 범위를 설정한다
            if(arr[i]){ // 받은 카드
                ++len;
            }
            else{ // 조커 카드
                if(used.size() < joker){ // 조커가 아직 있다면
                    used.offer(i);
                    ++len;
                }
                else{
                    if(used.isEmpty()){ // 조커가 처음부터 0개였다면
                        len = 0;
                    }
                    else { // 조커가 없다면 -> 앞의 조커부터 하나씩 뒤로 옮겨본다
                        int firstJokerCard = used.poll(); // 앞의 조커를 하나 빼서 뒤에서 사용하게 둔다
                        len = i - firstJokerCard; // 앞과 연결이 끊어지므로, 넣으려는 위치에서 빼려는 위치 사이가 길이가 된다
                        used.offer(i); // 앞의 조커를 뒤에 넣어 비교를 이어나간다
                    }
                }
            }
            ans = Math.max(ans, len); // 매 순간마다 결과를 계산한다
        }

        System.out.println(ans);
    }
}
