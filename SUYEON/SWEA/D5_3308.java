package SWEA;

import java.util.*;

public class D5_3308 { // O(nlogn)
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt(); // 원소 개수
            int[] arr = new int[N]; // 원소들 저장
            int[] LIS = new int[N]; // 각 위치는 LIS 길이를 만족하는 원소의 최소값을 의미

            for(int i=0; i<N; i++) {
                arr[i] = sc.nextInt();
            }

            int size = 0; // LIS size를 의미
            for(int i=0; i<N; i++) {
                // binarySearch를 통해, 삽입해야 하는 위치를 찾을 수 있음
                // 0부터 size-1까지 탐색하면서 arr[i]가 있는 인덱스 위치를 찾는다
                // -> 실패하면 arr[i]가 삽입되어야 하는 인덱스 위치가 음수 값으로 나온다
                int temp = Arrays.binarySearch(LIS, 0, size, arr[i]);
                // LIS는 주로 중복값이 없다 -> 중복값이 없으면 항상 탐색 실패하고 음수값이 리턴된다
                temp = Math.abs(temp)-1; // 삽입 위치를 찾기 위해 절대값-1해줌
                LIS[temp] = arr[i]; // 맨 뒤에 추가되거나, 기존위치에 덮어쓰거나 -> 최소값으로 계속 업데이트

                if(temp == size) ++size;
            }

            System.out.println("#"+test_case+" "+size);
        }
    }
}
