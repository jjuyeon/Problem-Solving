package BOJ;

import java.util.Scanner;

public class BOJ2941 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();

        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 'd'){
                if(i+1 < arr.length){
                    if(arr[i+1] == '-'){
                        ++i;
                    }
                    else if(i+2 < arr.length){
                        if(arr[i+1] == 'z' && arr[i+2] == '='){
                            i+=2;
                        }
                    }
                }
            }
            else if(arr[i] == 'l' || arr[i] == 'n'){
                if(i+1 < arr.length) {
                    if (arr[i+1] == 'j') {
                        ++i;
                    }
                }
            }
            else if(arr[i] == 's' || arr[i] == 'z' || arr[i] == 'c'){
                if(i+1 < arr.length) {
                    if (arr[i+1] == '=') {
                        ++i;
                    }
                    else if(arr[i] == 'c' && arr[i+1] == '-'){
                        ++i;
                    }
                }
            }

            ++count;
        }

        System.out.print(count);
    }
}
