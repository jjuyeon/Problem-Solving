package SWEA;

import java.util.Scanner;

public class D1_2050 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String T;
        T=sc.nextLine();

        String[] strArr = T.split("");
        for(int i=0; i<strArr.length; i++){
            System.out.print((strArr[i].charAt(0) - 64) + " ");
        }
    }
}
