package BOJ;

import java.io.*;

public class BOJ8911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            char[] command = br.readLine().toCharArray();
            move(command);
        }
    }

    private static void move(char[] command){
        int idx = 0;
        int[] dr = {1,0,-1,0}; // -> R 회전 , <- L 회전
        int[] dc = {0,1,0,-1};
        int[] saveX = new int[2]; // 작x, 큰x
        int[] saveY = new int[2]; // 작y, 큰y

        int x=0, y=0;
        for(char ch : command) {
            switch(ch){
                case 'F':
                    x += dr[idx];
                    y += dc[idx];
                    saveX[0] = Math.min(saveX[0], x); saveY[0] = Math.min(saveY[0], y);
                    saveX[1] = Math.max(saveX[1], x); saveY[1] = Math.max(saveY[1], y);
                    break;
                case 'B':
                    x -= dr[idx];
                    y -= dc[idx];
                    saveX[0] = Math.min(saveX[0], x); saveY[0] = Math.min(saveY[0], y);
                    saveX[1] = Math.max(saveX[1], x); saveY[1] = Math.max(saveY[1], y);
                    break;
                case 'L':
                    if(idx==0) idx=4;
                    --idx;
                    break;
                case 'R':
                    idx = (idx+1)%4;
            }
        }

        System.out.println((saveX[1]-saveX[0])*(saveY[1]-saveY[0]));
    }
}
