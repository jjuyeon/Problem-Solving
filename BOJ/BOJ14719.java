package BOJ;

import java.util.Scanner;

public class BOJ14719 {

    /**
     * int y: 블럭의 높이
     * int left: 왼쪽 끝부터 탐색했을 때, 빗물이 고일 수 있는 최대 높이
     * int right: 오른쪽 끝부터 탐색했을 때, 빗물이 고일 수 있는 최대 높이
     */
    static class Block {
        int y, left, right;

        Block(int y) {
            this.y = y;
        }
    }

    static Block[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();

        // 인덱스별로 블럭의 높이 저장
        // + 왼쪽부터 탐색해서 물이 고일 수 있는 최대 높이 업데이트
        int leftMax = 0;
        arr = new Block[W];
        for (int i = 0; i < W; i++) {
            int y = sc.nextInt();
            leftMax = Math.max(leftMax, y);
            arr[i] = new Block(y);
            arr[i].left = leftMax;
        }
        // 오른쪽부터 탐색해서 물이 고일 수 있는 최대 높이 업데이트
        int rightMax = 0;
        for (int i = W - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, arr[i].y);
            arr[i].right = rightMax;
        }

        calAnswer(W);
    }

    private static void calAnswer(int W) {
        int amount = 0;
        for (int i = 0; i < W; i++) {
            // 왼쪽부터 탐색 시 vs 오른쪽부터 탐색 시 최대 높이 중, 낮은 높이를 선택해서 현재 블럭의 높이만큼 빼준다
            amount += Math.min(arr[i].left, arr[i].right) - arr[i].y;
        }
        System.out.println(amount);
    }
}
