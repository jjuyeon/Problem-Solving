package BOJ;

import java.io.*;
import java.util.*;

public class BOJ3568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] commands = br.readLine().split(" ");
        Stack<Character> stack = new Stack<>();

        String common = commands[0];

        for(int i=1; i<commands.length; i++){
            String command = commands[i].trim();

            int valLength = 0;
            for(int j=0; j<command.length()-1; j++){
                if(command.charAt(j) == '['){
                    stack.push(']');
                }
                else if(command.charAt(j) == ']'){
                    stack.push('[');
                }
                else if(command.charAt(j) == '&' || command.charAt(j) == '*') {
                    stack.push(command.charAt(j));
                }
                else { // 변수명(변수명이 항상 1자리수라는 보장이 없음! -> 이것때문에 틀림)
                    ++valLength;
                }
            }

            StringBuilder valName = new StringBuilder();
            for(int j=0; j<valLength; j++){
                valName.append(command.charAt(j));
            }
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }

            System.out.println(common + sb.toString() + " " + valName.toString() + ";");
        }
    }
}
