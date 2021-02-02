package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());
        int S = stoi(br.readLine());

        int[][] shops = new int[S][2];
        for(int i=0; i<shops.length; i++){
            st = new StringTokenizer(br.readLine());
            shops[i][0] = stoi(st.nextToken());
            shops[i][1] = stoi(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int d = stoi(st.nextToken());
        int l = stoi(st.nextToken());

        System.out.print(findMinRoute(shops, d, l, N, M));
    }

    static int findMinRoute(int[][] shops, int dir, int loc, int width, int height){
        int sum = 0;
        if(dir == 1){ // 북
            for (int[] shop : shops) {
                if (shop[0] == 1) { // 북->북 (같은 줄로 이동하는게 이득)
                    sum += Math.abs(shop[1] - loc);
                } else if (shop[0] == 2) { // 북->남 (애매하므로 둘 다 비교)
                    sum += Math.min(loc + shop[1], width - loc + width - shop[1]) + height;
                } else if (shop[0] == 3) { // 북->서 (반시계가 이득)
                    sum += loc + shop[1];
                } else if (shop[0] == 4) { // 북->동 (시계가 이득)
                    sum += width - loc + shop[1];
                }
            }
        }
        else if(dir == 2){ // 남
            for (int[] shop : shops) {
                if (shop[0] == 1) { // 남->북 (애매하므로 둘 다 비교)
                    sum += Math.min(loc + shop[1], width - loc + width - shop[1]) + height;
                } else if (shop[0] == 2) { // 남->남 (같은 줄로 이동하는게 이득)
                    sum += Math.abs(shop[1] - loc);
                } else if (shop[0] == 3) { // 남->서 (시계가 이득)
                    sum += loc + height - shop[1];
                } else if (shop[0] == 4) { // 남->동 (반시계가 이득)
                    sum += width - loc + height - shop[1];
                }
            }
        }
        else if(dir == 3){ // 서
            for (int[] shop : shops) {
                if (shop[0] == 1) { // 서->북 (시계가 이득)
                    sum += loc + shop[1];
                } else if (shop[0] == 2) { // 서->남 (반시계가 이득)
                    sum += height - loc + shop[1];
                } else if (shop[0] == 3) { // 서->서 (같은 줄로 이동하는게 이득)
                    sum += Math.abs(shop[1] - loc);
                } else if (shop[0] == 4) { // 서->동 (애매하므로 둘 다 비교)
                    sum += Math.min(loc + shop[1], height - loc + height - shop[1]) + width;
                }
            }
        }
        else if(dir == 4){ // 동
            for (int[] shop : shops) {
                if (shop[0] == 1) { // 동->북 (반시계가 이득)
                    sum += loc + width - shop[1];
                } else if (shop[0] == 2) { // 동->남 (시계가 이득)
                    sum += height - loc + width - shop[1];
                } else if (shop[0] == 3) { // 동->서 (애매하므로 둘 다 비교)
                    sum += Math.min(loc + shop[1], height - loc + height - shop[1]) + width;
                } else if (shop[0] == 4) { // 동->동 (같은 줄로 이동하는게 이득)
                    sum += Math.abs(shop[1] - loc);
                }
            }
        }
        return sum;
    }

    static int stoi(String str){
        return Integer.parseInt(str);
    }
}
