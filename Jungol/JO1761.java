package Jungol;

import java.util.*;

public class JO1761 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] num = new String[n];
        int[] strike = new int[n];
        int[] ball = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.next();
            strike[i] = Integer.parseInt(sc.next());
            ball[i] = Integer.parseInt(sc.next());
        }

        int cnt, compare_strike, compare_ball, ans = 0;
        String youngsu_num;

        for (int i = 123; i <= 987; i++) {
            if(checkImpossible(i)){
                continue;
            }
            youngsu_num = String.valueOf(i);
            cnt = 0;
            for (int j = 0; j < n; j++) {
                compare_ball = 0;
                compare_strike = 0;
                for (int k = 0; k < 3; k++) {
                    if(youngsu_num.charAt(k) == num[j].charAt(k)) {
                        compare_strike++;
                    } else if(isBall(youngsu_num.charAt(k), num[j])){
                        compare_ball++;
                    }
                }
                if(compare_ball == ball[j] && compare_strike == strike[j]) {
                    cnt++;
                }
            }
            if(cnt == n) {
                ans++;
            }
        }

        System.out.print(ans);
    }

    private static boolean isBall(char youngsu_num, String num) {
        for (int i = 0; i < 3; i++) {
            if(youngsu_num == num.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkImpossible(int j) {
        Set<Integer> set = new HashSet<>();
        while(j != 0){
            set.add(j % 10);
            j /= 10;
        }
        return set.size() != 3 || set.contains(0); // 1-9까지임
    }
}
