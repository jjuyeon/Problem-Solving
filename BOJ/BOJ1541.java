package BOJ;

import java.util.Scanner;

public class BOJ1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();

        String[] number = line.split("-");
        int answer = 0;

        for (int i = 0; i < number.length; i++) {
            String[] arr = number[i].split("\\+");

            int result = 0;
            for (String str : arr) {
                result += stoi(str);
            }

            if(i == 0) {
                answer += result;
            }
            else {
                answer -= result;
            }
        }

        System.out.println(answer);
    }

    private static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
