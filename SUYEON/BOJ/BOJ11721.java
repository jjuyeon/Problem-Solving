import java.util.Scanner;

public class BOJ11721 {
    // 알파벳 소문자와 대문자로만 이루어진 길이가 N인 단어가 주어진다.
    //한 줄에 10글자씩 끊어서 출력하는 프로그램을 작성하시오.
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int i = 0;
        while(i<str.length()){
            if(i+10 > str.length()){
                System.out.println(str.substring(i));
            }
            else{
                System.out.println(str.substring(i,i+10));
            }
            i+=10;
        }
    }
}
