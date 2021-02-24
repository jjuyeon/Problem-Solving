package BOJ;

import java.util.*;

public class BOJ1652 { // 문제를 잘 이해하자!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        char[][] room = new char[n][n];
        for(int i=0; i<n; i++){
            room[i] = sc.next().toCharArray();
        }

        int garoAns = 0, seroAns = 0;
        for(int i=0; i<n; i++){
            int garoCnt = 0, seroCnt = 0;
            for(int j=0; j<n; j++){
                if(room[i][j] == '.'){
                    ++garoCnt;
                }
                else if(room[i][j] == 'X'){
                    if(garoCnt>=2){
                        ++garoAns;
                    }
                    garoCnt = 0;
                }

                if(room[j][i] == '.'){
                    ++seroCnt;
                }
                else if(room[j][i] == 'X'){
                    if(seroCnt>=2){
                        ++seroAns;
                    }
                    seroCnt = 0;
                }
            }

            if(garoCnt>=2) ++garoAns;
            if(seroCnt>=2) ++seroAns;
        }

        System.out.print(garoAns + " "+seroAns);
    }
}
