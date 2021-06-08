package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int area = 0;

        boolean[][] dohawji = new boolean[100][100];
        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int i=x; i<x+10; i++){
                for(int j=y; j<y+10; j++){
                    if(!dohawji[i][j]) {
                        dohawji[i][j] = true;
                        area++;
                    }
                }
            }
        }

        System.out.print(area);
    }
}
