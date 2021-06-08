import java.util.Scanner;

public class BOJ11718 {
    // 입력받은 그대로 출력 (최대 100줄) -- *** 알아야 할 것: scanner 클래스의 hasNextLine() 메소드 ***
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
    }
}
