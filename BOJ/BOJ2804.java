package BOJ;

import java.util.Scanner;

public class BOJ2804 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int width = b.length();
        int height = a.length();

        int crossX = 0, crossY = 0;
        boolean flag = false;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(a.charAt(i) == b.charAt(j)){
                    crossX = j;
                    crossY = i;
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }

        int idx = 0;
        for(int i=0; i<width; i++){
            if(i==crossX){
                System.out.println(a);
                idx++;
                continue;
            }

            for(int j=0; j<height; j++){
                if(j==crossY){
                    System.out.print(b.charAt(idx++));
                    continue;
                }
                System.out.print(".");
            }
            System.out.println();
        }
    }
}
