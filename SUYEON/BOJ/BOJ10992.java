import java.util.Scanner;

public class BOJ10992 {
    // 첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<n; i++){
            for(int j=n-i; j>0; j--){
                System.out.print(" ");
            }
            for(int k=1; k<=2*i-1; k++){
                if(k == 1 || k == (2*i-1))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
        for(int i=0; i<2*n-1; i++) {// 마지막줄
            System.out.print("*");
        }
    }
}
