package BOJ;

/**
 * 대표적인 재귀 유형(이해가 안되면 외우자!)
 */

import java.io.*;

public class BOJ11729 {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(hanoi(n,1,3,2));
        System.out.print(sb.toString());
    }
    static int hanoi(int n, int from, int to, int mid){
        if(n == 1){ // 경로 저장
            sb.append(from).append(" ").append(to).append("\n");
            return 1;
        }
        // n-1층까지(맨밑층 제외한 모든 층) 중간 저장공간으로 보냄 + 마지막 층을 도착지로 보냄 + 중간 저장공간에 있는 n-1층들을 도착지로 보냄
        return hanoi(n-1, from, mid, to) + hanoi(1, from, to, mid) + hanoi(n-1, mid, to, from);
    }
}
