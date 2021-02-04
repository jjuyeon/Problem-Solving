package BOJ;

import java.io.*;
import java.util.*;

class Node{ // 인덱스와 높이를 같이 저장하기 위한 클래스
    int idx;
    int height;

    Node(int idx, int height){
        this.idx = idx;
        this.height = height;
    }
}
public class BOJ2493 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Node[] tops = new Node[N+1];
        for(int i=1; i<=N; i++){
            tops[i] = new Node(i, stoi(st.nextToken()));
        }

        Stack<Node> stack = new Stack<>(); // 높이 비교할 때 탐색이 끝난 탑들을 관리하기 위함
        for(int i=1; i<=N; i++){
            boolean flag = false;
            while(!stack.isEmpty()){
                Node now = stack.pop();
                if(now.height >= tops[i].height){
                    sb.append(now.idx).append(" ");
                    stack.push(now); // 다시 신호를 받을 가능성이 있으므로 스택에 넣어줌
                    flag = true;
                    break;
                }
            }
            if(!flag){ // 스택을 다 비우고 나서도 신호를 받을 탑을 못찾으면 결과=0
                sb.append(0).append(" ");
            }

            stack.push(tops[i]); // 탐색이 끝났으므로 stack에 넣어줌
        }

        System.out.print(sb.toString());
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
