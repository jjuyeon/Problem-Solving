package BOJ;

import java.util.*;

public class BOJ4344 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++){
            int n = sc.nextInt();
            int[] students = new int[n];
            int average = 0;
            for(int i=0; i<n; i++){
                students[i] = sc.nextInt();
                average += students[i];
            }
            average /= n;

            double upStudent = 0;
            for(int i=0; i<n; i++){
                if(students[i] > average){
                    upStudent++;
                }
            }
            upStudent = (upStudent/n)*100.0;
            upStudent = Math.round(upStudent*1000)/1000.;
            System.out.println(String.format("%.3f",upStudent)+"%");
        }
    }
}
