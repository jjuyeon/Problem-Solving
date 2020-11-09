import java.util.*;

public class BOJ2446 {
    // 첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                System.out.print(" ");
            }
            for(int k=2*n-2*i; k>1; k--){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=1; i<n; i++){
            for(int j=n-1-i; j>0; j--){
                System.out.print(" ");
            }
            for(int k=0; k<2*i+1; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
