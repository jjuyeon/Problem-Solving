package BOJ;

import java.util.*;

public class BOJ2605 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> list = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(i == 1){
                list.add(sc.nextInt(), i);
                continue;
            }

            int lastIdx = list.size();
            int changeIdx = lastIdx - sc.nextInt();
            list.add(changeIdx, i);
        }

        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
