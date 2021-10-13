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

        int[] arr = new int[N]; // input �� ������� ����
        Map<Integer, Integer> map = new HashMap<>(); // �󵵼� ī������ �ڷᱸ��
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.putIfAbsent(arr[i], 0); // key ���� ���� ��, put ����
            map.computeIfPresent(arr[i], (k,v) -> v + 1); // key ���� ���� ��, ����
        }

        int[] result = new int[N]; // ����� ���� �迭
        Arrays.fill(result, -1);

        Stack<Pos> stack = new Stack<>();
        for (int i = 0; i < N; i++) { // ������ ���������� Ž��
            int now = map.get(arr[i]); // �󵵼�
            // ���� input ���� �󵵼��� ������ ������ ũ��
            // ����ū��(�����ʿ� �����鼭 �������� ������ Ƚ���� ���� input ������ ū ��) ��� �� �� �ִ�.
            while(!stack.isEmpty() && stack.peek().value < now) {
                // ���� �迭 �� ������ ���� ���� ���ڿ� ���� �ε����� ���� ���� �ִ´�.
                result[stack.pop().idx] = arr[i];
            }
            // �������� ���� (���� �ε���, ���� ���� �������� ������ Ƚ��) �� push
            stack.push(new Pos(i, now));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.print(sb);
    }
}

