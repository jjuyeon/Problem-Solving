package BOJ;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ13904 {

    static class Homework implements Comparable<Homework> {
        int d, w;
        Homework(int d, int w){
            this.d = d;
            this.w = w;
        }
        @Override
        public int compareTo(Homework o){
            if(this.d == o.d){
                return o.w - this.w;
            }
            return this.d - o.d;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Homework[] arr = new Homework[n];
        for(int i=0; i<n; i++){
            arr[i] = new Homework(sc.nextInt(), sc.nextInt());
        }
        // 과제 마감일까지 남은 일수가 적은 것부터 정렬시킨다
        Arrays.sort(arr);

        int date = 1; // 하루에 한 과제씩 끝낼 수 있으므로, 과제 마감일을 넘어갔는지 체크하기 위함
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 우선순위큐를 통해, 점수가 가장 적은 과제부터 큐에서 나오도록 함
        for(int i=0; i<n; i++){
            if(date <= arr[i].d){ // 마감일이 남았다
                pq.offer(arr[i].w); // 큐에 넣을 수 있다
                ++date; // 과제를 했으므로, 하루가 넘어간다
            } else { // 마감일이 지났다
                if(!pq.isEmpty()){ // 큐에 넣어둔 과제가 있다면
                    int min = pq.peek(); // 했던 과제 중 가장 점수가 낮은 과제가 나온다
                    if(min < arr[i].w){ // 했던 과제보다 현재 과제가 점수가 크다면
                        pq.poll(); // 이전에 했던 과제는 버리고
                        pq.offer(arr[i].w); // 새로운 과제를 한다
                        // 과제 하나를 버리고 새로운 과제를 추가했기 때문에, 중첩되므로 date를 업데이트 안해도 된다
                    }
                }
            }
        }

        int answer = 0;
        while(!pq.isEmpty()){ // 우선순위 큐에 담겨있는 과제의 점수가 총 점수의 최대값이다
            answer += pq.poll();
        }
        System.out.println(answer);
    }
}
