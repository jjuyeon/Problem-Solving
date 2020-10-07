import java.util.Scanner;

public class BOJ2440 {
    // 첫째 줄에는 별 N개, 둘째 줄에는 별 N-1개, ..., N번째 줄에는 별 1개를 찍는 문제
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            for(int j=n-i; j>0; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
