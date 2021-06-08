import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BOJ10828 {
    // 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
    private static Stack stack = new Stack();
    private static ArrayList<Integer> result = new ArrayList<Integer>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 주어지는 명령의 수

        while(N>=0){
            String put = sc.nextLine();
            String str1 = put.split(" ")[0];

            switch(str1){
                case "empty":
                    if(stack.empty()){
                        result.add(1);
                    }else{
                        result.add(0);
                    }
                    break;
                case "top":
                    if(stack.empty()){
                        result.add(-1);
                    }else{
                        result.add((int) stack.peek());
                    }
                    break;
                case "size":
                    result.add(stack.size());
                    break;
                case "pop":
                    if(stack.empty()){
                        result.add(-1);
                    }else{
                        result.add((int) stack.pop());
                    }
                    break;
                case "push":
                    int str2 = Integer.parseInt(put.split(" ")[1]);
                    stack.push(str2);
                    break;
            }
            N--;
        }

        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }
}
