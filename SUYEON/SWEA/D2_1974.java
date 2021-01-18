package SWEA;

import java.util.Scanner;

/**
 * flag 사용하는 로직을 이해하는 것이 중요
 */

public class D2_1974 {
    static int[][] sudoku;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            sudoku = new int[10][10];

            for(int i=1; i<=9; i++){
                for(int j=1; j<=9; j++){
                    sudoku[i][j] = sc.nextInt();
                }
            }

            boolean flag = false;
            // 가로
            for(int x=1; x<=9; x++){
                if(!checkGaro(x)){
                    System.out.printf("#%d %d%n", test_case, 0);
                    flag = true;
                    break;
                }
            }
            if(flag) continue; // test_case for문으로 돌아감

            // 세로
            for(int y=1; y<=9; y++){
                if(!checkSero(y)){
                    System.out.printf("#%d %d%n", test_case, 0);
                    flag = true;
                    break;
                }
            }
            if(flag) continue; // test_case for문으로 돌아감

            // 3x3 격자
            for(int x=1; x<=6; x+=3){
                for(int y=1; y<=6; y+=3){
                    if(!checkThreeByThree(x,y)){
                        System.out.printf("#%d %d%n", test_case, 0);
                        flag = true;
                        break;
                    }
                }
                if(flag) break; // flag가 일어났으므로 반복문 끝냄(출력문이 한번만 나오게 만들기 위함)
            }
            if(flag) continue; // test_case for문으로 돌아감

            System.out.printf("#%d %d%n", test_case, 1);
        }
    }

    static boolean checkGaro(int x){
        boolean[] checkNumber = new boolean[10];
        for(int y=1; y<=9; y++){
            if(checkNumber[sudoku[x][y]]){
                return false;
            }
            checkNumber[sudoku[x][y]] = true;
        }
        return true;
    }

    static boolean checkSero(int y){
        boolean[] checkNumber = new boolean[10];
        for(int x=1; x<=9; x++){
            if(checkNumber[sudoku[x][y]]){
                return false;
            }
            checkNumber[sudoku[x][y]] = true;
        }
        return true;
    }

    static boolean checkThreeByThree(int x, int y){
        boolean[] checkNumber = new boolean[10];
        for(int i=x; i<x+3; i++){
            for(int j=y; j<y+3; j++){
                if(checkNumber[sudoku[i][j]])
                    return false;

                checkNumber[sudoku[i][j]] = true;
            }
        }
        return true;
    }
}
