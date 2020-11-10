import java.util.*;

public class BOJ1655 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        int n = sc.nextInt();

        /*
        Heap 중간 값 구하기 알고리즘
        1. 최대 힙의 크기는 최소 힙의 크기와 같거나, 하나 더 크다.
        2. 최대 힙의 최대 원소는 최소 힙의 최소 원소보다 작거나 같다.
        이때 알고리즘에 맞지 않다면 최대 힙, 최소 힙의 가장 위의 값을 swap해준다.
        */
        for(int i=0; i<n; i++){
            int num = sc.nextInt();

            if(maxPQ.isEmpty() || maxPQ.size() == minPQ.size())
                maxPQ.offer(num);
            else
                minPQ.offer(num);

            if(!maxPQ.isEmpty() && !minPQ.isEmpty() && !(maxPQ.peek() <= minPQ.peek())){
                int max = maxPQ.poll();
                int min = minPQ.poll();

                maxPQ.offer(min);
                minPQ.offer(max);
            }

            sb.append(maxPQ.peek()).append("\n");
        }

        System.out.print(sb.toString());
    }
}
