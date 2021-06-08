package BOJ;

import java.io.*;
import java.util.*;

public class BOJ9742 {

    static char[] arr;
    static int len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            String input = br.readLine();
            if(input == null) break;

            st = new StringTokenizer(input);
            arr = st.nextToken().toCharArray();
            len = arr.length;
            int num = Integer.parseInt(st.nextToken());

            int cnt = 1;
            boolean flag = false;
            do{
                if(cnt == num){ // 성공
                    flag = true;
                    break;
                }
                ++cnt;
            }while(np());

            if(flag){ // 성공
                StringBuilder ans = new StringBuilder();
                for(int i=0; i<len; i++){
                    ans.append(arr[i]);
                }
                System.out.println(input + " = "+ans.toString());
            }
            else{ // 실패
                System.out.println(input + " = No permutation");
            }
        }
    }

    private static boolean np() {
        int i = len-1;
        while(i>0 && arr[i-1]>arr[i]) --i;
        if(i==0) return false;

        int j = len-1;
        while(arr[i-1]>arr[j]) --j;

        swap(i-1, j);

        int k = len-1;
        while(i<k){
            swap(i, k);
            --k; ++i;
        }

        return true;
    }

    private static void swap(int a, int b){
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
