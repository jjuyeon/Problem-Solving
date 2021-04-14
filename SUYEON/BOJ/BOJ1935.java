package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String command = br.readLine();
        double[] num = new double[N];
        for(int i=0; i<N; i++){
            num[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for(int i=0; i<command.length(); i++){
            char c = command.charAt(i);
            if(c == '/' || c == '*' || c == '+' || c == '-'){
                double result = cal(stack.pop(), stack.pop(), c);
                stack.push(result);
            }
            else{
                stack.push(num[c-'A']);
            }
        }

        System.out.print(String.format("%.2f", stack.pop()));
    }

    private static double cal(double a, double b, char operator){
        double result = 0;
        switch (operator){
            case '/':
                result = b/a;
                break;
            case '*':
                result = a * b;
                break;
            case '+':
                result = a + b;
                break;
            case '-':
                result = b-a;
        }
        return result;
    }
}
