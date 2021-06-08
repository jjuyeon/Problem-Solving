package SWEA;

import java.io.*;
import java.util.*;

public class D4_1233_dfs {

    static int n, isPossible;
    static String[] node;
    static Stack<Integer> stack; // 숫자 관리하기 위해 사용

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            n = Integer.parseInt(br.readLine());
            node = new String[n+1];
            stack = new Stack<>();

            for(int i=1; i<=n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int nodeNum = Integer.parseInt(st.nextToken());
                node[nodeNum] = st.nextToken();
            }

            isPossible = 1;
            dfs(1);
            sb.append("#").append(test_case).append(" ").append(isPossible).append("\n");
        }

        System.out.print(sb.toString());
    }

    private static void dfs(int idx){
        if(idx > n || isPossible == 0){
            return;
        }

        // 후위 순회
        dfs(2*idx);
        dfs(2*idx+1);
        if(node[idx].equals("*") || node[idx].equals("/") || node[idx].equals("+") || node[idx].equals("-")){
            if(stack.size() < 2){ // stack에 숫자가 2개 미만이면 연산 불가
                isPossible = 0;
                return;
            }
            stack.pop(); // 2개의 수로 연산해서 1개의 수로 결과가 나오므로 2-1개가 스택에 남는다 (지금은 계산 결과가 상관 없음)
        }
        else{
            stack.push(Integer.parseInt(node[idx]));
        }
    }
}
