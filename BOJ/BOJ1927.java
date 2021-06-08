import java.util.*;

public class BOJ1927 { // 최소힙
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // default: minHeap
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            if(num == 0){
                if(pq.size() == 0)
                    sb.append(0).append("\n");
                else
                    sb.append(pq.poll()).append("\n");
            }
            else{
                pq.add(num);
            }
        }
        System.out.print(sb.toString());
    }
}
