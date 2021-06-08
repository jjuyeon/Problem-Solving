import java.util.*;
import java.io.*;

public class BOJ9663 {
    static int[] col;
    static int n;
    static int answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        col = new int[n+1]; // 배열의 값은 '열'의 위치가 저장됨
        for(int i=1; i<=n; i++){
            col[1] = i; // 1행 i열에 queen을 놓았다 (초기 위치)
            dfs(1); // 1행 i열에 퀸을 놓았을 경우 가능한 경우 구하기
        }

        System.out.print(answer);
    }

    public static void dfs(int row){
        if(row == n){ // 마지막 줄까지 왔다는 것은 n개의 queen이 다 놓여졌다는 의미
            answer++; // 한 가지 경우 만들어졌으므로 +1
            return;
        }

        for(int i=1; i<=n; i++){
            col[row+1] = i;
            if(isPossible(row+1)){ // 2. 유망한 노드 검토
                dfs(row+1); // 3. 서브 트리 이동
            }else{ // 4. 백트래킹
                col[row+1] = 0;
            }
        }
    }

    public static boolean isPossible(int row){
        for(int i=1; i<row; i++){
            if(col[i] == col[row]) // 같은 열에 queen이 위치하면 안됨(같은 행, 같은 열에 하나씩!)
                return false;

            if(Math.abs(col[row] - col[i]) == Math.abs(row - i)) // 대각선에도 위치하면 안됨
                return false;
        }

        return true;
    }
}
