import java.util.Scanner;

public class BOJ1193 {
    // 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
    // X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int i;

        for(i=1; ;i++){
            x-=i;
            if(x<=0){
                break;
            }
        }

        int first, second;
        if(i%2==1){ // 대각선이 홀수번째 대각선일때
            first = -x+1;
            second = x+i;
        }else{ // 대각선이 짝수번째 대각선일때
            first = x+i;
            second = -x+1;
        }

        System.out.println(first+"/"+second);
    }
}
