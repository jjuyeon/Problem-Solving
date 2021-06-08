package BOJ;

import java.util.*;

public class BOJ3040 {

    static int[] caps = new int[9];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<9; i++){
            caps[i] = sc.nextInt();
        }

        combination(0, 0, new int[7], 0);
    }

    private static void combination(int start, int idx, int[] selected, int sum){
        if(idx == 7){
            if(sum == 100){
                for(int i : selected){
                    System.out.println(i);
                }
            }
            return;
        }

        for(int i=start; i<9; i++){
            selected[idx] = caps[i];
            combination(i+1, idx+1, selected, sum+caps[i]);
        }
    }
}
