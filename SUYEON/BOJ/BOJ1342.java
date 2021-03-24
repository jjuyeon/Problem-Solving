package BOJ;

import java.util.Scanner;
import java.util.Arrays;

public class BOJ1342 {

    static char[] arr;
    static int len;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        arr = sc.next().toCharArray();
        len = arr.length;
        Arrays.sort(arr);

        int ans = 0;
        do{
            if(checkLuckyStr()){
                ++ans;
            }
        }while(np());

        System.out.print(ans);
    }

    private static boolean checkLuckyStr(){
        for(int i=1; i<len; i++){
            if(arr[i] == arr[i-1]) return false;
        }
        return true;
    }

    private static boolean np(){
        int i = len-1;
        while(i>0 && arr[i-1]>=arr[i]) --i;
        if(i==0) return false;

        int j = len-1;
        while(arr[i-1]>=arr[j]) --j;

        swap(i-1, j);

        int k = len-1;
        while(i<k){
            swap(i, k);
            ++i; --k;
        }
        return true;
    }

    private static void swap(int a, int b){
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
