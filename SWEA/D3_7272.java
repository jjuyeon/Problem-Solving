package SWEA;

import java.util.*;

public class D3_7272 {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String str1 = sc.next();
            String str2 = sc.next();

            if(str1.length() != str2.length()){
                sb.append("#").append(test_case).append(" ").append("DIFF").append("\n");
                continue;
            }

            boolean flag = false;
            for(int i=0; i<str1.length(); i++){
                if(whereAlphabet(str1.charAt(i)) != whereAlphabet(str2.charAt(i))){
                    flag = true;
                    break;
                }
            }
            if(flag){
                sb.append("#").append(test_case).append(" ").append("DIFF").append("\n");
            }else{
                sb.append("#").append(test_case).append(" ").append("SAME").append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    static int whereAlphabet(Character alphabet){
        List<Character> zero = Arrays.asList('C', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
        List<Character> one = Arrays.asList('A', 'D', 'O', 'P', 'Q', 'R');

        if(zero.contains(alphabet))
            return 0;

        if(one.contains(alphabet))
            return 1;

        return 2;
    }
}
