package SWEA;

import java.util.Scanner;
import java.util.ArrayList;

public class D3_1234 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++) {
            ArrayList<Character> list = new ArrayList<>();
            int n = sc.nextInt();
            String str = sc.next();
            for(int i=0; i<n; i++){
                list.add(str.charAt(i));
            }

            boolean flag = true;
            while(flag){
                for(int i=1; i<list.size(); i++){
                    if(list.get(i-1) == list.get(i)){
                        list.remove(i-1); // i-1 인덱스의 값 삭제
                        list.remove(i-1); // i-1의 값이 삭제되면서 인덱스가 자동으로 업데이트되므로 i->i-1이 됨
                        flag = true; // 같은 번호로 붙어있는 쌍들을 발견하여 삭제했다면 아직 가능성이 있으므로 다시 검사
                        break;
                    }
                    flag = false;
                }
            }

            sb.append("#").append(test_case).append(" ");
            for (Character ch : list) {
                sb.append(ch);
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
