import java.util.Scanner;

public class BOJ1011 {
    // x지점부터 정확히 y지점으로 이동하는데 필요한 공간 이동 장치 작동 횟수의 최솟값을 구하는 프로그램을 작성하라.
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 입력의 첫 줄에는 테스트케이스의 개수 T가 주어진다.
        int put = sc.nextInt();
        int result[] = new int[put];

        for(int i=0; i<put; i++){
            // 각각의 테스트 케이스에 대해 현재 위치 x 와 목표 위치 y 가 정수로 주어지며, x는 항상 y보다 작은 값을 갖는다. ( 0 ≤ x < y < 231)
            int x = sc.nextInt();
            int y = sc.nextInt();
            int distance = y-x;

            for(double j=1; ; j++){
                double standard=j*j+j;
                if(standard>=distance){
                    if(distance<=j*j){
                        result[i] = (int) (2*j-1);
                    }else{
                        result[i] = (int) (2*j);
                    }
                    break;
                }
            }
        }

        for(int i=0; i<put; i++){
            System.out.println(result[i]);
        }
    }
}
