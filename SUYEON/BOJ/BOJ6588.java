package BOJ;

import java.util.*;

/**
 * TODO: 에라토스테네스의 체
 * https://brenden.tistory.com/48
 */
public class BOJ6588 {
    static boolean[] prime;
    public static void main(String[] args){

        prime = new boolean[1000001];
        get_prime();

        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while(num != 0){
            boolean isPrimeResult = false;
            for(int i=2; i<=num/2; i++){
                if(prime[i] && prime[num-i]){
                    sb.append(num).append(" = ").append(i).append(" + ").append(num-i).append("\n");
                    isPrimeResult = true;
                    break;
                }
            }
            if(!isPrimeResult)
                sb.append("Goldbach's conjecture is wrong.\n");

            num = sc.nextInt();
        }
        System.out.print(sb.toString());
    }

    static void get_prime(){
        for(int i=2; i<=1000000; i++){
            prime[i] = true;
        }
        for(int i=2; i<=1000000; i++){
            if(!prime[i])
                continue;

            for(int j=i*2; j<=1000000; j+=i){
                prime[j] = false;
            }
        }
    }
}
