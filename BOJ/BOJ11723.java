package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11723 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int bitmask = 0;
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operator = st.nextToken();
            if(operator.equals("add")){
                int x = Integer.parseInt(st.nextToken());
                bitmask = bitmask | (1<<(x-1));
            }
            else if(operator.equals("remove")){
                int x = Integer.parseInt(st.nextToken());
                bitmask = bitmask & ~(1<<(x-1));
            }
            else if(operator.equals("check")){
                int x = Integer.parseInt(st.nextToken());
                if((bitmask&(1<<(x-1))) == 0){
                    sb.append(0).append("\n");
                }
                else{
                    sb.append(1).append("\n");
                }
            }
            else if(operator.equals("toggle")){
                int x = Integer.parseInt(st.nextToken());
                bitmask = bitmask ^ (1<<(x-1));
            }
            else if(operator.equals("all")){
                bitmask |= (~0);
                // bitmask = (1<<20) - 1;
            }
            else if(operator.equals("empty")){
                bitmask = 0;
            }
        }

        System.out.print(sb.toString());
    }
}
