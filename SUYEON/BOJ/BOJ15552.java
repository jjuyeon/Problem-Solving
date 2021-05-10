package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 방법1
        StringBuilder sb = new StringBuilder(); // 방법2

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());

            sb.append(a+b).append("\n");

            // bw.write(String.valueOf(a+b)); // String형으로의 변환이 필요
            // bw.newLine();
        }
        System.out.print(sb);

        // bw.flush();
        // br.close();
        // bw.close();
    }
}
