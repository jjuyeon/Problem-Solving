package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1158_LinkedList {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();

        for(int i=1; i<=n; i++){
            list.add(i);
        }

        int delIdx = 0;
        while(list.size() > 1){
            delIdx = (delIdx + k - 1) % list.size();
            sb.append(list.remove(delIdx % list.size())).append(", ");
        }
        sb.append(list.remove());

        System.out.print("<"+sb.toString()+">");
    }
}
