import java.util.Scanner;

public class BOJ10991 {
    // 첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            for(int j=n-i; j>1; j--){
                System.out.print(" ");
            }
            for(int k=1; k<=2*i+1; k++){
                if(k%2 == 0){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
