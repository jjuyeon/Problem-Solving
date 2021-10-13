package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17299 {

    static class Pos {
        int idx, value;

        Pos(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N]; // input 값 순서대로 저장
        Map<Integer, Integer> map = new HashMap<>(); // 빈도수 카운팅할 자료구조
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.putIfAbsent(arr[i], 0); // key 값이 없을 때, put 연산
            map.computeIfPresent(arr[i], (k,v) -> v + 1); // key 값이 있을 때, 연산
        }

        int[] result = new int[N]; // 결과를 담을 배열
        Arrays.fill(result, -1);

        Stack<Pos> stack = new Stack<>();
        for (int i = 0; i < N; i++) { // 수열을 순차적으로 탐색
            int now = map.get(arr[i]); // 빈도수
            // 현재 input 값의 빈도수가 스택의 값보다 크면
            // 오등큰수(오른쪽에 있으면서 수열에서 등장한 횟수가 현재 input 값보다 큰 수) 라고 할 수 있다.
            while(!stack.isEmpty() && stack.peek().value < now) {
                // 정답 배열 중 스택의 가장 위쪽 숫자와 같은 인덱스에 현재 값을 넣는다.
                result[stack.pop().idx] = arr[i];
            }
            // 다음번에 비교할 (현재 인덱스, 현재 값의 수열에서 등장한 횟수) 를 push
            stack.push(new Pos(i, now));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.print(sb);
    }
}

