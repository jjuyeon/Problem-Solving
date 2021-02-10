package BOJ;

import java.io.*;
import java.util.*;

public class BOJ3985 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int l = stoi(br.readLine());
        int n = stoi(br.readLine());

        int expectedNum = 0, realNum = 0;
        int expectedCnt = 0, realCnt = 0;
        int[] arr = new int[l+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int from = stoi(st.nextToken());
            int to = stoi(st.nextToken());
            int count = 0;
            for(int j=from; j<=to; j++){
                if(arr[j] == 0){
                    arr[j] = i;
                    count++;
                }
            }

            if(expectedCnt < (to-from+1)){
                expectedCnt = to-from+1;
                expectedNum = i;
            }
            if(realCnt < count){
                realCnt = count;
                realNum = i;
            }
        }

        System.out.println(expectedNum);
        System.out.println(realNum);
    }

    static int stoi(String str){
        return Integer.parseInt(str);
    }
}
