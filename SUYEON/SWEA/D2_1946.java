package SWEA;

import java.io.*;
import java.util.*;

public class D2_1946 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringBuilder sb = new StringBuilder();
            int lineCount = 0;
            int n = Integer.parseInt(br.readLine());
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String alphabet = st.nextToken();
                int count = Integer.parseInt(st.nextToken());
                for(int j=0; j<count; j++){
                    if(lineCount == 10){
                        sb.append("\n");
                        lineCount = 0;
                    }
                    sb.append(alphabet);
                    lineCount++;
                }
            }

            System.out.printf("#%d%n%s%n", test_case, sb.toString());
        }
    }
}
