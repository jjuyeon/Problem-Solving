package BOJ;

import java.util.Scanner;

public class BOJ18512 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int p1 = sc.nextInt();
        int p2 = sc.nextInt();

        int cnt = 0;
        while(cnt<100){
            if(p1<p2){
                p1+=x;
            }
            else if(p2<p1){
                p2+=y;
            }
            else{
                System.out.println(p1);
                break;
            }
            ++cnt;
        }

        if(cnt == 100){
            System.out.println(-1);
        }
    }
}
