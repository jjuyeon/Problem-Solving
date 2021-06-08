import java.util.*;

public class BOJ1260_ver_matrix {
    // 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

    static void dfs(int[][] a, boolean[] checked, int start_vertex){ // using stack
        Stack<Integer> stack = new Stack<>();
        stack.push(start_vertex);
        checked[start_vertex] = true;
        System.out.print(start_vertex+" ");
        while(!stack.isEmpty()){
            int now_vertex = stack.peek();
            boolean flag = false;

            for(int i=1; i<a.length; i++){
                if(a[now_vertex][i] == 1 && !checked[i]){ // 간선으로 연결 & 아직 방문 안함
                    stack.push(i);
                    System.out.print(i + " ");
                    checked[i] = true;
                    flag = true;
                    break;
                }
            }
            if(!flag){ // 반복문을 한번도 통과하지 않음(즉, 연결된 간선이 없고, 방문하지 않은 정점을 못찾음)
                stack.pop();
            }
        }
        System.out.println();
    }

    static void bfs(int[][] a, boolean[] checked, int start_vertex){ // using queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start_vertex);
        checked[start_vertex] = true;
        System.out.print(start_vertex+" ");
        while(!queue.isEmpty()){
            int now_vertex = queue.remove();
            for(int i=1; i<a.length; i++){
                if(a[now_vertex][i] == 1 && !checked[i]){
                    queue.add(i);
                    System.out.print(i + " ");
                    checked[i] = true;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        int[][] a = new int[N+1][N+1]; // 인접행렬 사용

        for(int i=0; i<M; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            a[start][end] = 1;
            a[end][start] = 1;
        }

        boolean[] checked = new boolean[N+1]; // 방문여부 체크
        dfs(a, checked, V);
        Arrays.fill(checked, false); // 다시 초기화
        bfs(a, checked, V);
    }
}
