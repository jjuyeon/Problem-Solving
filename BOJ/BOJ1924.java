import java.util.Scanner;
public class BOJ1924 {
    // 오늘은 2007년 1월 1일 월요일이다. 그렇다면 2007년 x월 y일은 무슨 요일일까? 이를 알아내는 프로그램을 작성하시오.
    public static void main(String[] args){
        // 참고로 2007년에는 1, 3, 5, 7, 8, 10, 12월은 31일까지, 4, 6, 9, 11월은 30일까지, 2월은 28일까지 있다.
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int answer = 0;
        for(int i=0; i<x-1; i++){
            answer += month[i];
        }
        answer = (answer + y) % 7;
        System.out.println(day[answer]);
    }
}
