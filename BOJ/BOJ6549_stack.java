import java.util.*;
import java.io.*;

class Map {
    int index;
    long height;

    Map(int i, long h){
        this.index = i;
        this.height = h;
    }
}

public class BOJ6549_stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            String readLine = br.readLine();
            if(readLine.equals("0")) // 종료조건
                break;

            Stack<Map> stack = new Stack<>();
            st = new StringTokenizer(readLine);
            long answer = 0;

            int n = stoi(st.nextToken());
            for(int i=0; i<n; i++){
                long now_height = stol(st.nextToken());
                if(stack.isEmpty()){
                   stack.push(new Map(i, now_height));
                   continue;
                }

                if(stack.peek().height <= now_height){
                    stack.push(new Map(i, now_height));
                }else{
                    int min_idx = 0;
                    while(!stack.isEmpty() && (stack.peek().height > now_height)){
                        Map top_stack = stack.pop();
                        answer = Math.max(answer, (i-top_stack.index) * top_stack.height);
                        min_idx = top_stack.index;
                    }
                    stack.push(new Map(min_idx, now_height));
                }
            }

            while(!stack.isEmpty()){
                Map top_stack = stack.pop();
                answer = Math.max(answer, (n - top_stack.index) * top_stack.height);
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb.toString());
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
    static long stol(String s) { return Long.parseLong(s); }
}
