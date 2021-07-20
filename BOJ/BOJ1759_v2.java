package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1759_v2 {

    static int l, c;
    static String[] arr;
    static String[] vowels = {"a", "e", "i", "o", "u"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = Integer.parseInt(sc.next());
        c = Integer.parseInt(sc.next());

        arr = new String[c];
        for (int i = 0; i < c; i++) {
            arr[i] = sc.next();
        }

        Arrays.sort(arr);

        recur(0, 0, new String[l]);
    }

    static void recur(int start, int idx, String[] selected) {
        if(idx == l) {
            if(check(selected)) {
                for (int i = 0; i < l; i++) {
                    System.out.print(selected[i]);
                }
                System.out.println();
            }
            return;
        }

        for (int i = start; i < c; i++) {
            selected[idx] = arr[i];
            recur(i+1, idx+1, selected);
        }
    }

    static boolean check(String[] selected) {
        int cons = 0, vowel = 0;
        for (int i = 0; i < l; i++) {
            if(isVowel(selected[i])) {
                ++vowel;
            } else {
                ++cons;
            }
        }

        return (cons >= 2) && (vowel >= 1);
    }

    static boolean isVowel(String str) {
        for (int i = 0; i < 5; i++) {
            if(str.equals(vowels[i])) {
                return true;
            }
        }
        return false;
    }
}
