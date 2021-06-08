package BOJ;

import java.io.*;
import java.util.*;

public class BOJ15663 { // 중복없는 순열
    static boolean[] visited;
    static int[] arr;
    static HashSet<String> answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        answer = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        permutation(n,m,0, "");
        for(String s : answer){
            System.out.println(s);
        }
    }

    public static void permutation(int n, int m, int count, String result){
        if(m == count){
            answer.add(result);
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                permutation(n,m,count+1, result+arr[i]+" ");
                visited[i] = false;
            }
        }
    }
}