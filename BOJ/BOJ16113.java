package BOJ;

import java.io.*;
import java.util.Arrays;

public class BOJ16113 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        String str = br.readLine();

        char[][] map = new char[5][len/5];
        for(int i=0; i<5; i++){
            for(int j=0; j<len/5; j++){
                map[i][j] = str.charAt((len/5)*i + j);
            }
        }

        findNumber(map);
    }

    private static void findNumber(char[][] map) {
        String[] arr = {
                "####.##.##.####",
                ".#..#..#..#..#.",
                "###..#####..###",
                "###..####..####",
                "#.##.####..#..#",
                "####..###..####",
                "####..####.####",
                "###..#..#..#..#",
                "####.#####.####",
                "####.####..####"
        };

        StringBuilder result = new StringBuilder();
        int len = map[0].length;

        for(int i=0; i<len; ){
            if(map[0][i] == '.' && map[2][i] == '.'){ // 숫자 아님
                ++i;
                continue;
            }

            // 숫자인 경우
            StringBuilder number = new StringBuilder();
            for(int k=0; k<5; k++) {
                for(int j=i; j<i+3; j++){
                    if(j >= len) break; // 범위 벗어나지 않도록 체크
                    number.append(map[k][j]);
                }
            }

            int n;
            for(n=0; n<10; n++){
                if(number.toString().equals(arr[n])){ // 특수한 경우(1)를 제외한 모든 수 검사
                    result.append(n);
                    i += 3;
                    break;
                }
            }
            if(n == 10){ // 1인 경우임
                result.append(1);
                ++i;
            }
        }

        System.out.println(result.toString());
    }
}
