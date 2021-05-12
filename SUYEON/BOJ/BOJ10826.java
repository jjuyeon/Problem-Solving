package BOJ;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ10826 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println(0);
        } else if (n == 1) {
            System.out.println(1);
        } else {
            String[] arr = new String[n+1];
            arr[0] = "0";
            arr[1] = "1";
            for (int i = 2; i <= n; i++) {
                arr[i] = cal(arr[i-1], arr[i-2]);
            }
            System.out.println(arr[n]);
        }
    }

    private static String cal(String str1, String str2){
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        LinkedList<Integer> list = new LinkedList<>();
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
            list.addFirst(cal);
        }
        if(plus == 1){
            list.addFirst(1);
        }

        StringBuilder result = new StringBuilder();
        for (int i : list) {
            result.append(i);
        }

        return result.toString();
    }
}
