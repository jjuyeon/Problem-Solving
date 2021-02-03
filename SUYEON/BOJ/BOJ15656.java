package BOJ;

import java.util.*;
import java.io.*;

public class BOJ15656 { // 중복있는 순열
    static StringBuilder sb = new StringBuilder();
    static int[] arr, answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        answer = new int[n];
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        permutation(n,m,0);
        System.out.print(sb.toString());
    }

    public static void permutation(int n, int m, int count){
        if(m == count){
            for(int i=0; i<m; i++)
                sb.append(answer[i]).append(" ");
            sb.append("\n");
            return;
        }
        for(int i=0; i<n; i++){
            answer[count] = arr[i];
            permutation(n,m,count+1);
        }
    }
}
