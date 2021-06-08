import java.util.*;
import java.io.*;

public class BOJ16571 {
    static int[][] game = new int[3][3];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int now = 0;
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                game[i][j] = Integer.parseInt(st.nextToken());;
                if(game[i][j] == 0) now++;
            }
        }

        now = (now % 2 == 0)? 2 : 1; // 홀수면 x(1)차례, 짝수면 o(2)차례
        int gameResult = playGame(now);
        String answer;
        switch(gameResult){
            case -1:
                answer = "L";
                break;
            case 1:
                answer = "W";
                break;
            default:
                answer = "D";
        }
        System.out.print(answer);
    }

    static int playGame(int now){
        int next = 3-now; // 다음 사람
        if(isWin(next)){
            return -1; // 현재 상태에서 상대방이 이겼다면 진거다
        }
        int nextResult = 2; // 1: win (Im lose), 0: draw, -1: lose (Im win) -> 작을수록 now 한테 좋은거
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(game[i][j] == 0){ // 놓을 수 있는 자리일 때 경우의 수 따지기
                    game[i][j] = now; // 지금 자리에 now를 놓고
                    nextResult = Math.min(nextResult, playGame(next)); // 상대턴으로 넘어갔을 때 결과값과 비교(상대방이 져야(-1) 이길 수 있음)
                    game[i][j] = 0; // 해당 경우에 대한 판단은 끝났으므로 원래대로 되돌린다
                }
            }
        }
        if(nextResult == 2) nextResult = 0; // 업데이트가 안됬다는 건 승부가 안났다는 것
        return -nextResult; // now의 결과는 상대방의 결과에 반대이므로
    }

    static boolean isWin(int now){
        for(int i=0; i<3; i++){ // 가로,세로가 빙고일 경우
            if(game[i][0] == now && game[i][1] == now && game[i][2] == now) return true;
            if(game[0][i] == now && game[1][i] == now && game[2][i] == now) return true;
        }
        // 대각선이 빙고일 경우
        if(game[0][0] == now && game[1][1] == now && game[2][2] == now) return true;
        if(game[0][2] == now && game[1][1] == now && game[2][0] == now) return true;

        return false;
    }
}
