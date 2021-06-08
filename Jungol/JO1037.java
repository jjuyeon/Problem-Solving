package Jungol;

import java.util.Scanner;

public class JO1037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int seroF = 0, garoF = 0;
        boolean[] sero = new boolean[n];
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i][j] == 1) ++sum;
            }
            if (sum % 2 == 0) sero[j] = true;
            else ++seroF;
        }

        boolean[] garo = new boolean[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) ++sum;
            }
            if (sum % 2 == 0) garo[i] = true;
            else ++garoF;
        }

        if(seroF==0 && garoF==0){
            System.out.print("OK");
        }

        else if(seroF==1 && garoF==1){
            int seroIdx = 0, garoIdx = 0;
            for(int i=0; i<n; i++){
                if(!sero[i]){
                    seroIdx = i;
                }
                if(!garo[i]){
                    garoIdx = i;
                }
            }
            System.out.printf("Change bit (%d,%d)", garoIdx+1, seroIdx+1); // 인덱스는 1부터 시작
        }

        else{
            System.out.print("Corrupt");
        }
    }

}
