package BOJ;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ10757 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] a = sc.next().toCharArray();
        char[] b = sc.next().toCharArray();
        LinkedList<Integer> result = new LinkedList<>();

        int idxa = a.length-1;
        int idxb = b.length -1;
        int plus = 0;
        while(true){
            if(idxa == -1 && idxb == -1){
                break;
            }

            int cal;
            if(idxa >= 0 && idxb >= 0){
                cal = (a[idxa--] - '0') + (b[idxb--] - '0') + plus;
            } else if(idxa >=0) {
                cal = (a[idxa--] - '0') + plus;
            } else {
                cal = (b[idxb--] - '0') + plus;
            }
            plus = cal / 10;
            cal %= 10;
            result.addFirst(cal);
        }
        if(plus == 1){
            result.addFirst(1);
        }
        for (int i : result) {
            System.out.print(i);
        }
    }
}
