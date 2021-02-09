package SWEA;

import java.io.*;
import java.util.*;

public class D4_1233 {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            boolean isPossible = true;
            int n = Integer.parseInt(br.readLine());
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int node = Integer.parseInt(st.nextToken());
                String value = st.nextToken();
                if(node*2 <=n && node*2+1 <= n){
                    if (!value.equals("+") && !value.equals("-") && !value.equals("*") && !value.equals("/")) {
                        isPossible = false;
                    }
                }
                else{ // 리프노드
                    if(value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")){
                        isPossible = false;
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(isPossible? 1 : 0).append("\n");
        }

        System.out.print(sb.toString());
    }
}
