package Jungol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class JO2809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        int sq = (int) Math.sqrt(n);
        for (int i = 1; i <= sq; i++) {
            if(n % i == 0) {
                list.add(i);
                if(n / i != i){
                    list.add(n/i);
                }
            }
        }

        Collections.sort(list);
        for (int i : list) {
            System.out.printf("%d ", i);
        }
    }
}
