package BOJ;

import java.io.*;
import java.util.*;

public class BOJ15665 { // 중복있는 순열
    static int[] arr;
    static HashSet<String> answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

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
            permutation(n,m,count+1, result+arr[i]+" ");
        }
    }
}