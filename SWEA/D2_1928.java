package SWEA;

import java.io.*;
import java.util.Base64;
import static java.util.Base64.*;

public class D2_1928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());

        Decoder decoder = Base64.getDecoder();
        for(int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            byte[] encodingByte = str.getBytes();
            byte[] decodingByte = decoder.decode(encodingByte);

            System.out.printf("#%d %s%n", test_case, new String(decodingByte));
        }
    }
}
