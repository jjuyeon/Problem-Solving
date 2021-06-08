package SWEA;

import java.util.*;

public class D3_1493 {

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static Point[] points;

    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();

        points = new Point[300*300+1];
        makeSet();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int p = sc.nextInt();
            int q = sc.nextInt();

            sb.append("#").append(test_case).append(" ").append(findValue(points[p].x+points[q].x, points[p].y+points[q].y)).append("\n");
        }

        System.out.print(sb.toString());
    }

    private static void makeSet(){
        int count = 1, nx, ny;
        for(int i=1; i<=300*300;){
            nx = 1; ny = count;
            for(int j=1; j<=count; j++) {
                if(i == 300*300+1){
                    break;
                }
                points[i++] = new Point(nx++, ny--);
            }
            count++;
        }
    }

    private static int findValue(int x, int y){
        for(int i=1; i<=300*300; i++){
            if(points[i].x == x && points[i].y == y){
                return i;
            }
        }

        return 0;
    }
}
