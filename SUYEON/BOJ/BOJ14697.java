package BOJ;

import java.util.Scanner;
import java.util.Arrays;

/**
 * 배정된 모든 방에 빈 침대가 없도록 하고자 한다
 * 세 종류의 방을 모두 활용하지 않고 한 종류 또는 두 종류의 방만 이용하여 배정하는 것도 허용
 */
public class BOJ14697 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] room = {sc.nextInt(),sc.nextInt(),sc.nextInt()};
        int n = sc.nextInt();

        for(int i=0; i<=300; i++){ // 하나도 안뽑는 경우부터 최대로 300개 있을 수 있음
            for(int j=0; j<=300; j++){
                for(int k=0; k<=300; k++){
                    if(n == room[0]*i + room[1]*j + room[2]*k){
                        System.out.print(1);
                        return;
                    }
                }
            }
        }

        System.out.print(0);
    }
}
