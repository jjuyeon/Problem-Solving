package BOJ;

import java.util.Scanner;

public class BOJ17413 {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        boolean isTag = false;
        int startIdx = 0;
        for(int i=0; i<str.length(); i++){
            if(!isTag && str.charAt(i) == ' '){
                sb.append(makeReverse(str, startIdx, i-1)).append(' ');
                startIdx = i+1;
            }
            else if(str.charAt(i) == '<'){
                sb.append(makeReverse(str, startIdx, i-1));
                startIdx = i;
                isTag = true;
            }
            else if(str.charAt(i) == '>'){
                sb.append(str.substring(startIdx, i+1));
                startIdx = i+1;
                isTag = false;
            }
        }

        if(str.charAt(str.length()-1) != '>'){
            sb.append(makeReverse(str, startIdx, str.length()-1)).append(' ');
        }

        System.out.print(sb.toString());
    }

    static String makeReverse(String s, int startIdx, int endIdx){
        StringBuilder result = new StringBuilder();
        for(int i=endIdx; i>=startIdx; i--){
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}
