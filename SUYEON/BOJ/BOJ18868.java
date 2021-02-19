package BOJ;

import java.util.*;

public class BOJ18868 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] planet = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                planet[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=i+1; j<m; j++){
                if(checkSpace(planet[i], planet[j])){
                    ans++;
                }
            }
        }

        System.out.print(ans);
    }

    private static boolean checkSpace(int[] a, int[] b){
        for(int i=0; i<a.length; i++){
            for(int j=i+1; j<a.length; j++){
                if(a[i]<a[j] && b[i]<b[j]){
                    continue;
                }
                else if(a[i]==a[j] && b[i]==b[j]){
                    continue;
                }
                else if(a[i]>a[j] && b[i]>b[j]){
                    continue;
                }

                return false;
            }
        }
        return true;
    }
}
