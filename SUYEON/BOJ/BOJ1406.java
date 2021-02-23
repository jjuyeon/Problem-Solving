package BOJ;

import java.io.*;
import java.util.Stack;

public class BOJ1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int m = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for(int i=0; i<line.length(); i++){
            left.push(line.charAt(i));
        }

        for(int i=0; i<m; i++){
            String command = br.readLine();
            switch (command.charAt(0)) {
                case 'L':
                    if(!left.isEmpty()){
                        right.push(left.pop());
                    }
                    break;
                case 'D':
                    if(!right.isEmpty()){
                        left.push(right.pop());
                    }
                    break;
                case 'B':
                    if(!left.isEmpty()){
                        left.pop();
                    }
                    break;
                case 'P':
                    left.push(command.charAt(2));
            }
        }

        StringBuilder ans = new StringBuilder();
        while(!left.isEmpty()){
            ans.append(left.pop());
        }
        ans.reverse();
        while(!right.isEmpty()){
            ans.append(right.pop());
        }

        System.out.print(ans.toString());
    }
}
