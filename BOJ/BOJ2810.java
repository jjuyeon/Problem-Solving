package BOJ;

import java.util.*;

public class BOJ2810 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        String str = sc.next();

        int ans = 0;
        for(int i=0; i<n; i++){
            if(str.charAt(i) == 'S'){
                ++ans;
            }
            else if(str.charAt(i) == 'L'){
                ++ans;
                ++i;
            }
        }
        ++ans;

        if(ans>n) ans = n;

        System.out.print(ans);
    }
}
