package Jungol;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JO1311 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> alpha = new HashMap<>();
        int[] num = new int[5];

        for (int i = 0; i < 5; i++) {
            alpha.put(sc.next(), 1);
            num[i] = Integer.parseInt(sc.next());
        }

        int ans = 0;
        Arrays.sort(num);

        int ch = num[0];
        boolean isOneAndFive = true;
        for (int i = 1; i < 5; i++) {
            if(ch + 1 != num[i]){
                isOneAndFive = false;
                break;
            }
            ch++;
        }
        if(isOneAndFive) {
            // 카드 5장이 모두 같은 색
            if(alpha.keySet().size() == 1) { // 1번 조건
                ans = Math.max(ans, num[4] + 900);
            }
            else { // 5번 조건
                ans = Math.max(ans, num[4] + 500);
            }
        }

        if(alpha.keySet().size() == 1) { // 4번 조건
            ans = Math.max(ans, num[4] + 600);
        }


        // 숫자 개수 조건
        int[] count = new int[10];
        for (int i = 0; i < 5; i++) {
            count[num[i]]++;
        }

        int three = 0, two = 0, threeNum = 0;
        int[] twoNum = new int[2];
        for (int i = 1; i < 10; i++) {
            if(count[i] == 4) {
                ans = Math.max(ans, i + 800); // 2번 조건
                break;
            } else if(count[i] == 3) {
                three++;
                threeNum = i;
            } else if(count[i] == 2) {
                two++;
                if(twoNum[0] == 0) {
                    twoNum[0] = i;
                } else {
                    twoNum[1] = i;
                }
            }
        }

        if(three == 1 && two == 1) { // 3번 조건
            ans = Math.max(ans, 10*threeNum + twoNum[0] + 700);
        }
        else if(three == 1){ // 6번 조건
            ans = Math.max(ans, threeNum + 400);
        }
        else if(two == 2) { // 7번 조건
            ans = Math.max(ans, 10*twoNum[1] + twoNum[0] + 300);
        }
        else if(two == 1) { // 8번 조건
            ans = Math.max(ans, twoNum[0] + 200);
        }

        ans = Math.max(ans, num[4] + 100); // 9번 조건

        System.out.print(ans);
    }
}
