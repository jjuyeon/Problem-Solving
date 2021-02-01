package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class D3_1289 {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String origin = sc.next();
            char[] change = new char[origin.length()];
            Arrays.fill(change, '0');

            int minCount = 0;
            for(int i=0; i<origin.length(); i++){ // 한자리씩 비교
                if(origin.charAt(i) != change[i]) { // 같은 인덱스에 있는 값이 같지 않다면
                    Arrays.fill(change, i, origin.length(), origin.charAt(i)); // i인덱스부터 끝까지 값을 update
                    minCount++;
                }
            }
            sb.append("#").append(test_case).append(" ").append(minCount).append("\n");
        }
        System.out.print(sb.toString());
    }
}
