package BOJ;

import java.util.Scanner;

public class BOJ2839 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ans = combination(n);
        System.out.print(ans);
    }

    private static int combination(int n){
        int count = Integer.MAX_VALUE;

        for(int i=0; ; i++){
            int sum = n, temp = 0;
            for(int j=0; j<i; j++){ // 5kg을 얼만큼 채울 건지
                sum-=5;
                ++temp;
            }
            if(sum < 0){
                break;
            }

            if(sum%3 == 0){ // 나머지를 3kg으로 채울 수 있으면 연산
                temp += sum/3;
                count = Math.min(count, temp);
            }
        }

        if(count == Integer.MAX_VALUE) count = -1;
        return count;
    }
}
