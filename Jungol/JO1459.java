package Jungol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class JO1459 {

    static int n;
    static int[] arr;
    static boolean[] visited;
    static ArrayList<Integer> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        result = new ArrayList<>();
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int i :
                result) {
            System.out.println(i);
        }
    }

    static void dfs(int start, int target) {
        if (!visited[arr[start]]) {
            visited[arr[start]] = true;
            dfs(arr[start], target);
            visited[arr[start]] = false;
        }

        if (arr[start] == target) result.add(target);
    }
}
