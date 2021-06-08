package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] paints = new boolean[101][101];
        int n = Integer.parseInt(br.readLine());
        for(int l=0; l<n; l++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int i=x; i<x+10; i++){
                for(int j=y; j<y+10; j++){
                    paints[i][j] = true;
                }
            }
        }

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int ans = 0;
        for(int i=1; i<=100; i++){
            for(int j=1; j<=100; j++){

                // 둘레인지 넓이인지 확인(제일 쉬운 방법)
                if(paints[i][j]){
                    for(int k=0; k<4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(nx>=1 && nx<=100 && ny>=1 && ny<=100){
                            if(!paints[nx][ny]) ans++;
                        }
                        else{
                            ans++;
                        }
                    }
                }

//                // 둘레인지 그냥 공간인지 확인
//                if(i==1 || i==100 || j==1 || j==100){ // 사이드일 때는 둘레 체크 따로 해줘야함(사방탐색이 불가능한 영역이 있으므로)
//                    if(paints[i][j]) ans++;
//                }
//
//                if(!paints[i][j]){
//                    for(int k=0; k<4; k++) {
//                        int nx = i + dx[k];
//                        int ny = j + dy[k];
//                        if(nx>=1 && nx<=100 && ny>=1 && ny<=100) {
//                            if (paints[nx][ny]) ans++;
//                        }
//                    }
//                }
            }
        }

        System.out.print(ans);
    }
}
