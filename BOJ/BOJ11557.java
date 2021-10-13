package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11557 {

    static class School implements Comparable<School> {
        String country;
        int amount;

        School(String country, int amount) {
            this.country = country;
            this.amount = amount;
        }

        @Override
        public int compareTo(School o) {
            return o.amount - this.amount;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.next());

        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(sc.next());

            School[] arr = new School[N];
            for (int i = 0; i < N; i++) {
                arr[i] = new School(sc.next(), Integer.parseInt(sc.next()));
            }

            Arrays.sort(arr);

            System.out.println(arr[0].country);
        }
    }
}
