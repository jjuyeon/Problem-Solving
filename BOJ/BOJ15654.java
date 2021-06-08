package BOJ;

import java.io.*;
import java.util.*;

public class BOJ15654 { // 중복없는 순열
    static boolean[] visited;
    static int[] arr, answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        answer = new int[n];

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        permutation(n,m,0);
    }

    public static void permutation(int n, int m, int count){
        if(m == count){
            for(int i=0; i<m; i++)
                System.out.print(answer[i] + " ");
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[count] = arr[i];
                permutation(n,m,count+1);
                visited[i] = false;
            }
        }
    }
}