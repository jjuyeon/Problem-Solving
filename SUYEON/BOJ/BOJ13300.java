package BOJ;

import java.util.Scanner;

/**
 * 남학생은 남학생끼리, 여학생은 여학생끼리 방을 배정해야 한다.
 * 한 방에는 같은 학년의 학생들을 배정해야 한다.
 * 한 방에 한 명만 배정하는 것도 가능하다.
 */
public class BOJ13300 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] students = new int[7][2];
        for(int i=0; i<n; i++){
            int sex = sc.nextInt();
            int grade = sc.nextInt();

            ++students[grade][sex];
        }

        int ans = 0;
        for(int i=1; i<=6; i++){
            ans += students[i][0]/k + students[i][1]/k;
            if(students[i][0] % k != 0) ++ans;
            if(students[i][1] % k != 0) ++ans;
        }

        System.out.print(ans);
    }
}
