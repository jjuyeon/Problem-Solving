package Jungol;

import java.util.Scanner;

public class JO2259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] head = {1, 4, 2, 3};
        int[] tail = {3, 1, 4, 2};

        int maxWidth = 0, maxHeight = 0;
        int[] dir = new int[6];
        int[] len = new int[6];
        for (int i = 0; i < 6; i++) {
            dir[i] = sc.nextInt();
            len[i] = sc.nextInt();
            if (dir[i] == 1 || dir[i] == 2) {
                maxWidth = Math.max(maxWidth, len[i]);
            } else {
                maxHeight = Math.max(maxHeight, len[i]);
            }
        }
        int prevDir = dir[0], prevLen = len[0], minusArea = 0;
        for (int i = 1; i < 6; i++) {
            if (checkMinusArea(prevDir, dir[i], head, tail)) {
                minusArea = prevLen * len[i];
                break;
            } else {
                prevDir = dir[i];
                prevLen = len[i];
            }
        }
        // 다 돌았는데 아직 작은 사각형을 발견하지 못한 경우! <- 이때는 마지막 꼭지점->처음 꼭지점 순환할 때, 작은 사각형이 생기는 경우의 수도 생각해야 한다!!!!
        if(minusArea == 0 && checkMinusArea(prevDir, dir[0], head, tail)) { // [틀린 부분] 순환되는걸 생각못함..!!!
            minusArea = prevLen * len[0];
        }

            System.out.print((maxWidth * maxHeight - minusArea) * k);
        }

        private static boolean checkMinusArea ( int prev, int now, int[] head, int[] tail){
            for (int i = 0; i < 4; i++) {
                if (head[i] == prev && tail[i] == now) {
                    return true;
                }
            }
            return false;
        }
    }
