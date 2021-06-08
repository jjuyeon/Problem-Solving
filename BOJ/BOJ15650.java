package BOJ;

import java.util.*;
import java.io.*;

public class BOJ15650 { // 중복없는 조합
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        answer = new int[n+1];

        combination(n, m, 0, 1);
    }

    public static void combination(int n, int m, int count, int start){
        if(m == count){
            for(int i=0; i<m; i++)
                System.out.print(answer[i] + " ");
            System.out.println();
            return;
        }

        for(int i=start; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[count] = i;
                combination(n,m,count+1, i+1);
                visited[i] = false;
            }
        }
    }
}
