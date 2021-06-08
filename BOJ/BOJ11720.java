import java.util.*;
public class BOJ11720 {
    // N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        int answer = 0;
        for(int i=0; i<n; i++){
            answer += Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        System.out.println(answer);
    }
}
