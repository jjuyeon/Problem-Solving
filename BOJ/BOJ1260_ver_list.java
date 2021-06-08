import java.util.*;

public class BOJ1260_ver_list {
    // 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

    static void dfs(ArrayList<Integer>[] a, boolean[] checked, int start_vertex){ // using recursive
        checked[start_vertex] = true;
        System.out.print(start_vertex + " ");
        for(int vertex : a[start_vertex]){
            if(!checked[vertex]){
                dfs(a,checked,vertex);
            }
        }
    }

    static void bfs(ArrayList<Integer>[] a, boolean[] checked, int start_vertex){ // using queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start_vertex);
        checked[start_vertex] = true;
        System.out.print(start_vertex+" ");
        while(!queue.isEmpty()){
            int now_vertex = queue.remove();
            for(int i=0; i<a[now_vertex].size(); i++){
                int next_vertex = a[now_vertex].get(i);
                if(!checked[next_vertex]){
                    queue.add(next_vertex);
                    System.out.print(next_vertex + " ");
                    checked[next_vertex] = true;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[N+1]; // Arraylist 사용
        for(int i=0; i<N+1; i++){ // 각각의 배열마다 초기화
            a[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            int vertex1 = sc.nextInt();
            int vertex2 = sc.nextInt();
            a[vertex1].add(vertex2);
            a[vertex2].add(vertex1);
        }

        for(int i=1; i<N+1; i++){ // "방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문" 조건때문에 sort 해줘야 함(안해서 틀림)
            Collections.sort(a[i]);
        }

        boolean[] checked = new boolean[N+1]; // 방문여부 체크
        dfs(a, checked, V);
        System.out.println();
        Arrays.fill(checked, false); // 다시 초기화
        bfs(a, checked, V);
    }
}
