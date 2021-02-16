package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class D3_6808 {

    static int[] gyuCards, inCards;

    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            gyuCards = new int[9];
            inCards = new int[9];
            for(int i=0; i<9; i++){ // 규영이 카드 만들기
                gyuCards[i] = sc.nextInt();
            }

            int idx = 0; // 인영이 카드 만들기
            for(int i=1; i<=18; i++){
                if(checkNum(i)){
                    inCards[idx++] = i;
                }
            }

            int win = 0, lose = 0;
            // 인영이가 만들 수 있는 모든 카드 경우의 수에 대해 계산
            do{
                int gSum = 0, iSum = 0;

                for(int i=0; i<9; i++){
                    if(gyuCards[i] > inCards[i]){
                        gSum += gyuCards[i] + inCards[i];
                    }
                    else{
                        iSum += gyuCards[i] + inCards[i];
                    }
                }
                if(gSum > iSum) win++;
                else if(gSum < iSum) lose++;
            }while(np());

            sb.append("#").append(test_case).append(" ").append(win).append(" ").append(lose).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static boolean np(){
        int i = 9-1; // 꼭대기 찾기
        while(i>0 && inCards[i-1]>=inCards[i]){
            i--;
        }

        if(i == 0){
            return false;
        }

        int j = 9-1; // 바꿀 위치 찾기
        while(inCards[i-1] >= inCards[j]){
            j--;
        }

        swap(i-1, j);

        int k = 9-1; // 바꾼 뒷부분 오름차순으로 바꿔주기
        while(i<k){
            swap(i, k);
            i++; k--;
        }

        return true;
    }

    private static void swap(int i, int j){
        int temp = inCards[i];
        inCards[i] = inCards[j];
        inCards[j] = temp;
    }

    private static boolean checkNum(int n){
        for(int i=0; i<9; i++){
            if(gyuCards[i] == n){
                return false;
            }
        }
        return true;
    }
}
