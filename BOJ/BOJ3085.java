package BOJ;

import java.io.*;

public class BOJ3085 {
    static char[][] game;
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        game = new char[n][n];
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<n; j++){
                game[i][j] = line.charAt(j);
            }
        }

        int max = -1;
        for(int i=0; i<n; i++){ // 기준: 열
            for(int j=1; j<n; j++){
                swap(i,j-1, i, j);
                max = Math.max(max, check());
                swap(i,j-1, i, j);
            }
        }

        for(int j=0; j<n; j++){ // 기준: 행
            for(int i=1; i<n; i++){
                swap(i-1, j, i, j);
                max = Math.max(max, check());
                swap(i-1, j, i, j);
            }
        }
        System.out.println(max);
    }

    static int check(){
        int total = 0;
        for(int i=0; i<n; i++){
            int count = 1;
            for(int j=1; j<n; j++){
                if(game[i][j-1] == game[i][j]){
                    count++;
                }
                else{
                    total = Math.max(total, count);
                    count = 1;
                }
            }
            /**
             * 내가 간과한 점: 반복문 다 끝나고 마지막으로 total max값으로 업데이트해줘야함
             */
            total = Math.max(total, count);
        }

        for(int j=0; j<n; j++){
            int count = 1;
            for(int i=1; i<n; i++){
                if(game[i-1][j] == game[i][j]){
                    count++;
                }
                else{
                    total = Math.max(total, count);
                    count = 1;
                }
            }
            /**
             * 내가 간과한 점: 반복문 다 끝나고 마지막으로 total max값으로 업데이트해줘야함
             */
            total = Math.max(total, count);
        }
        return total;
    }

    /**
     * col/row 상관없이 사용할 수 있는 swap 함수 간단하게 만드는 법 익숙해지기 (함수 두개 안만들어도 ㄱㅊ)
     */
    static void swap(int r1, int c1, int r2, int c2){
        char temp = game[r1][c1];
        game[r1][c1] = game[r2][c2];
        game[r2][c2] = temp;
    }
}
