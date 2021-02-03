package BOJ;

import java.util.*;
import java.io.*;

public class BOJ15666 { // 중복있는 조합
    static int[] arr;
    static HashSet<String> answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        answer = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        arr = new int[n]; // int배열로 해야하는 이유: 오름차순할 때 문제생김
        for(int i=0; i<n; i++) { // 문자열로 받게 되면 1 2 3 4 5 6 7 8 9 가 아닌 1 10 11 12 13 ... 2 21 22 ... 이런식으로 정렬됨
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        combination(n, m, 0, 0, "");
        for(String s : answer){
            System.out.println(s);
        }
    }

    public static void combination(int n, int m, int count, int start, String result){
        if(m == count){
            answer.add(result);
            return;
        }

        for(int i=start; i<n; i++){
            combination(n,m,count+1, i, result+arr[i]+" ");
        }
    }
}
