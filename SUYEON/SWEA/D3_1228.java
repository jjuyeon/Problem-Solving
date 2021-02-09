package SWEA;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 왜 연결리스트를 사용하는 문제? 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입하는 문제이다
 * linkedList는 뒤에 어떤 노드(값)이 오는지 그 주소를 저장하여 삽입, 삭제
 *  ArrayList처럼 뒤로 밀거나 채우는 작업 없이 주소만 서로 연결시켜 주면 되기 때문에 추가 삭제가 ArrayList보다 빠르고 용이
 *  삽입삭제가 빈번하게 발생되면 Linked List을 사용해 시스템 구현이 바람직힘
 */
public class D3_1228 {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = sc.nextInt();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i=0; i<n; i++){
                list.add(sc.nextInt());
            }

            int command = sc.nextInt();
            for(int i=0; i<command; i++){
                String code = sc.next();
                int x = sc.nextInt();
                int y = sc.nextInt();
                for(int j=0; j<y; j++){
                    if(code.equals("I")) {
                        list.add(x, sc.nextInt());
                        x++;
                    }
                }
            }

            sb.append("#").append(test_case).append(" ");
            for(int i=0; i<10; i++){
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
