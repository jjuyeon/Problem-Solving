package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class BOJ11576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // a진법을 10진법으로 풀어서 저장
        int m = sc.nextInt(); // 자리수 개수
        int ans = 0;
        for(int i=1; i<=m; i++){ // 각 자리수가 높은 자릿수부터 차례대로 들어옴
            int num = sc.nextInt();
            ans += Math.pow(a, m-i) * num;
        }
        // 10진법으로 표현된 수를 b진법으로 변환
        Stack<Integer> stack = new Stack<>();
        while(ans>0){
            stack.push(ans%b);
            ans/=b;
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
