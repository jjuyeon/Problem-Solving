import java.util.*;
import java.io.*;

public class BOJ15652 {
    static StringBuilder sb = new StringBuilder();
    static int[] answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        answer = new int[n+1];

        dfs(n,m,0);
        System.out.print(sb.toString());
    }

    public static void dfs(int n, int m, int count){
        if(m == count){
            for(int i=1; i<m; i++){
                if(answer[i] < answer[i-1]){
                    return;
                }
            }
            for(int i=0; i<m; i++)
                sb.append(answer[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=1; i<=n; i++){
            answer[count] = i;
            dfs(n,m,count+1);
        }
    }
}
