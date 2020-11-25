import java.io.*;
import java.util.*;

public class BOJ15649 {
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        answer = new int[n+1];

        dfs(n,m,0);
    }

    public static void dfs(int n, int m, int count){
        if(m == count){
            for(int i=0; i<m; i++)
                System.out.print(answer[i] + " ");
            System.out.println();
            return;
        }

        for(int i=1; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[count] = i;
                dfs(n,m,count+1);
                visited[i] = false;
            }
        }
    }
}