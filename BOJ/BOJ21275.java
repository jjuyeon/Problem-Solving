package BOJ;

import java.util.Scanner;

public class BOJ21275 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        // [놓친 부분] a,b의 최소 진법을 구해야 답이 이상하게 안나옴
        int aJinbub = 0, bJinbub = 0;
        for(int i=0; i<a.length(); i++){
            char ch = a.charAt(i);
            if (ch <= '9') aJinbub = Math.max(aJinbub, ch-'0');
            else aJinbub = Math.max(aJinbub, (ch - 'a' + 10));
        }
        for(int i=0; i<b.length(); i++){
            char ch = b.charAt(i);
            if (ch <= '9') bJinbub = Math.max(bJinbub, ch-'0');
            else bJinbub = Math.max(bJinbub, (ch - 'a' + 10));
        }

        // 계산 부분
        long X = -1;
        int A = -1, B = -1;
        for(int i=aJinbub+1; i<=36; i++){
            for(int j=bJinbub+1; j<=36; j++){
                if(i==j) continue;
                long resultA = checkJinbub(a, i);
                long resultB = checkJinbub(b, j);
                if(resultA == resultB){
                    if(resultA >= Math.pow(2,63)) continue;
                    if(X != -1){
                        System.out.print("Multiple");
                        return;
                    }
                    A = i;
                    B = j;
                    X = resultA;
                }
            }
        }
        if(X == -1) {
            System.out.print("Impossible");
        }
        else{
            System.out.print(X+" "+A+" "+B);
        }
    }

    private static long checkJinbub(String str, int jinbub) {
        int len = str.length();
        long num = 0;
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(len - 1 - i);
            if (ch <= '9') num += (ch - '0') * Math.pow(jinbub, i);
            else num += (ch - 'a' + 10) * Math.pow(jinbub, i);
        }
        return num;
    }
}
