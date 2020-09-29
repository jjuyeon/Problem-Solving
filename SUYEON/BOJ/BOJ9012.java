import java.util.Scanner;
import java.util.Stack;

public class BOJ9012 {
    // 입력으로 주어진 괄호 문자열이 VPS(올바른 괄호 문자열)인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어라.
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] result = new String[N];

        for(int i=0; i<N; i++){
            try{
                String str = sc.nextLine();
                String[] array_word = str.split("");
                Stack stack = new Stack();

                for (String anArray_word : array_word) {
                    if(anArray_word.equals("(")){
                        stack.push(anArray_word);
                    }else{
                        stack.pop();
                    }
                }

                // 만일 입력 괄호 문자열이 올바른 괄호 문자열(VPS)이면 “YES”, 아니면 “NO”를 한 줄에 하나씩 차례대로 출력한다.
                if(stack.empty()){
                    result[i] = "YES";
                }else{
                    result[i] = "NO";
                }
            }catch(Exception e){
                result[i] = "NO";
            }
        }

        for(String str: result){
            System.out.println(str);
        }
    }
}
