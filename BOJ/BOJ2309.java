package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2309 {

    static boolean flag;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] heights = new int[9];
        for(int i=0; i<9; i++){
            heights[i] = sc.nextInt();
        }
        Arrays.sort(heights); // 오름차순

        flag = false;
        combination(heights, 0, 0, new int[7], 0);
    }

    private static void combination(int[] heights, int start, int idx, int[] selected, int sum){
        if(flag){
            return;
        }

        if(idx == 7){
            if(sum == 100){
                for(int i : selected){
                    System.out.println(i);
                }

                flag = true; // 가능한 정답이 여러 가지인 경우에는 아무거나 "한 가지 경우만" 출력하도록 한다
            }
            return;
        }

        for(int i=start; i<9; i++){
            selected[idx] = heights[i];
            combination(heights, i+1, idx+1, selected, sum+heights[i]);
        }
    }
}
