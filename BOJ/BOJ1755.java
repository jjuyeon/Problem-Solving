package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1755 {

    static class Alphabet implements Comparable<Alphabet>{
        String str; // 숫자를 알파벳 문자열로 변환한 값
        int num; // 숫자

        Alphabet(int num, String str){ // 생성자
            this.num = num;
            this.str = str;
        }

        @Override
        public int compareTo(Alphabet o) { // 오름차순 정렬하기 위해 custom
            int result = 0;
            int size = Math.min(this.str.length(), o.str.length());
            for(int i=0; i<size; i++) { // 한 문자씩 비교
                if(this.str.charAt(i) > o.str.charAt(i)) { // 현재 문자가 더 크다면
                    result = 1; // 1을 반환
                    break;
                }
                else if(this.str.charAt(i) < o.str.charAt(i)) { // 비교 문자가 더 크다면
                    result = -1; // -1을 반환
                    break;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 범위 받기
        int m = sc.nextInt(); // m 이상
        int n = sc.nextInt(); // n 이하

        if(m>n) return; // 범위를 벗어나므로 그냥 끝낸다

        // 0~9까지 각각에 대응하는 알파벳 문자열로 저장해둔 배열
        String[] alphabet = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        Alphabet[] answer = new Alphabet[n-m+1]; // 정답 배열
        int idx = 0; // 정답 배열 인덱스
        for(int i=m; i<=n; i++) {
            String str = ""; // i에 대응하는 알파벳 문자열을 저장하기 위함
            int num = i;
            while(num>0) { // 한자리씩 잘라서
                str = alphabet[num%10] + str; // 문자열로 전환한다
                num /= 10; // 다음 자리를 비교하기 위해 10으로 나눠준다
            }
            answer[idx++] = new Alphabet(i, str); // 숫자(i)와 숫자와 대응하는 알파벳 문자열을 함께 정답 배열에 저장한다
        }
        Arrays.sort(answer); // 오름차순 정렬

        // 정답 출력
        for(int i=0; i<n-m+1; i++) {
            if(i!=0 && i%10 == 0) { // 한 줄에 10개씩 출력한다
                System.out.println(); // 한 줄에 10개가 만들어졌다면 다음 줄로 넘어가도록 한다
            }
            System.out.print(answer[i].num + " "); // 정렬된 문자를 출력한다
        }

        sc.close();
    }
}
