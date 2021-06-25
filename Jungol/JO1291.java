package Jungol;

import java.util.Scanner;

public class JO1291 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s, e;
        while(true){
            s = Integer.parseInt(sc.next());
            e = Integer.parseInt(sc.next());
            if(s>=2 && s<=9 && e>=2 && e<=9){
                break;
            }
            System.out.println("INPUT ERROR!");
        }

        if (s < e) {
            for(int j=1; j<=9; j++) {
                for (int i = s; i <= e; i++) {
                    if(i==s){
                        System.out.printf("%d * %d =%3d", i, j, i*j);
                        continue;
                    }
                    System.out.printf("%4d * %d =%3d", i, j, i*j);
                }
                System.out.println();
            }
        } else {
            for(int j=1; j<=9; j++) {
                for (int i = s; i >= e; i--) {
                    if(i==s){
                        System.out.printf("%d * %d =%3d", i, j, i*j);
                        continue;
                    }
                    System.out.printf("%4d * %d =%3d", i, j, i*j);
                }
                System.out.println();
            }
        }
    }
}
