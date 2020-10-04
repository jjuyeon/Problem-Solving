import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간초과와 메모리초과 에러를 방지하기 위해 최적화를 해보자
// Scanner(space를 모두 경계로 인식, 가공 쉬움, 효율 낮음) ->
// BufferedReader(많은 데이터를 입력받을 경우 효율 좋음, enter만 경계로 인식, 일정량 사이즈로 한번에 읽어온 후 버퍼에 보관, Exception처리 해줘야함)
// br.readLine().split(" ") -> StringTokenizer(br.readLine(), " ")
// System.out.print(오버헤드가 쌓여 성능 저하를 초래함) -> StringBuilder(기존의 데이터를 더하는 방식을 사용, 속도도 빠르며 상대적으로 부하가 적음)

public class BOJ11728 {
    // 정렬되어있는 두 배열 A와 B가 주어진다. 두 배열을 합친 다음 정렬해서 출력하는 프로그램을 작성하시오.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] a = new int[N];
        int[] b = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 sort
        Arrays.sort(a);
        Arrays.sort(b);

        print_answer(solve(a,b,N,M));
    }

    static int[] solve(int[] a, int[] b, int N, int M){
        int[] answer = new int[N+M];
        int index_a = 0;
        int index_b = 0;
        int index = 0;

        while(index_a < N && index_b < M){
            if(a[index_a] <= b[index_b]){ // a의 원소값이 b의 원소값보다 작을 때
                answer[index++] = a[index_a++];
            }else{ // b의 원소값이 a의 원소값보다 작을 때
                answer[index++] = b[index_b++];
            }
        }
        while(index_a < N){ // 아직 a 배열에 원소가 남아있을 경우
            answer[index++] = a[index_a++];
        }
        while(index_b < M){ // 아직 b 배열에 원소가 남아있을 경우
            answer[index++] = b[index_b++];
        }

        return answer;
    }

    static void print_answer(int[] answer){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<answer.length; i++)
            sb.append(answer[i] + " ");
        System.out.println(sb.toString());
    }
}
