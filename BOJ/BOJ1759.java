package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1759 {

    static int l, c;
    static String[] alphabet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        alphabet = br.readLine().split(" ");
        Arrays.sort(alphabet);
        combination(0, 0, new String[l]);
    }

    private static void combination(int start, int idx, String[] selected){
        if(idx == l){
            if(checkAvailablePwd(selected)){
                printAvailablePwd(selected);
            }
            return;
        }

        for(int i=start; i<c; i++){
            selected[idx] = alphabet[i];
            combination(i+1, idx+1, selected);
        }
    }

    private static boolean checkAvailablePwd(String[] selected){
        int consonant = 0, vowel = 0;
        for(int i=0; i<l; i++){
            if(selected[i].equals("a") || selected[i].equals("e") || selected[i].equals("i") || selected[i].equals("o") || selected[i].equals("u")){
                ++vowel;
            }
            else {
                ++consonant;
            }
        }

        if(vowel<1 || consonant<2){
            return false;
        }

        return true;
    }

    private static void printAvailablePwd(String[] selected){
        Arrays.sort(selected);
        for(int i=0; i<l; i++){
            System.out.print(selected[i]);
        }
        System.out.println();
    }
}
