import java.util.Scanner;

public class BOJ2439 {
    // 오른쪽을 기준으로 정렬한 별을 출력하시오.
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<=n; i++){
            for(int j=n-i; j>0; j--){
                System.out.print(" ");
            }
            for(int k=1; k<=i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
