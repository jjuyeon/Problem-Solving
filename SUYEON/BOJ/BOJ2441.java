import java.util.Scanner;

public class BOJ2441 {
    // 첫째 줄에는 별 N개, 둘째 줄에는 별 N-1개, ..., N번째 줄에는 별 1개를 찍는 문제
    //하지만, 오른쪽을 기준으로 정렬한 별을 출력하시오.
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                System.out.print(" ");
            }
            for(int k=n-i; k>0; k--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
