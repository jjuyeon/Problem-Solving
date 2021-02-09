package SWEA;

import java.io.*;
import java.util.*;

public class D3_1230 {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            LinkedList<String> list = new LinkedList<>();
            for(int i=0; i<n; i++){
                list.add(st.nextToken());
            }

            int command = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<command; i++){
                String code = st.nextToken();
                int x, y;
                if(code.equals("A")){
                    y = Integer.parseInt(st.nextToken());
                    for(int j=0; j<y; j++) {
                        list.add(st.nextToken());
                    }
                }
                else if(code.equals("I")) {
                    x = Integer.parseInt(st.nextToken());
                    y = Integer.parseInt(st.nextToken());
                    for(int j=0; j<y; j++) {
                        list.add(x++, st.nextToken());
                    }
                }
                else if(code.equals("D")) {
                    x = Integer.parseInt(st.nextToken());
                    y = Integer.parseInt(st.nextToken());
                    for(int j=0; j<y; j++) {
                        list.remove(x);
                    }
                }
            }

            sb.append("#").append(test_case).append(" ");
            for(int i=0; i<10; i++){
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
