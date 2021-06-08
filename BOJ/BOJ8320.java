package BOJ;

import java.util.Scanner;

public class BOJ8320 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int answer = 0;
        for(int i=1; i<=n/2; i++){
            for(int j=i; j<=n/i; j++){
                answer++;
            }
        }

        if(n == 1)
            answer = 1;

        System.out.print(answer);
    }
}
