package SWEA;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 시뮬레이션 문제
 */

public class D3_1873 {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int x = -1, y = -1;

            char[][] map = new char[H][W];
            for(int i=0; i<H; i++){
                String str = sc.next();
                for(int j=0; j<W; j++){
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>'){
                        x = i;
                        y = j;
                    }
                }
            }

            int N = sc.nextInt();
            char[] commands = sc.next().toCharArray();
            // 게임 스타트
            for(int c = 0; c<N; c++){
                char command = commands[c];
                if(command == 'U'){
                    if(x-1>=0 && map[x-1][y] == '.'){
                        map[x][y] = '.';
                        x -= 1;
                    }
                    map[x][y]= '^';
                }
                else if(command == 'D'){
                    if(x+1<H && map[x+1][y] == '.'){
                        map[x][y] = '.';
                        x += 1;
                    }
                    map[x][y] = 'v';
                }
                else if(command == 'L'){
                    if(y-1>=0 && map[x][y-1] == '.'){
                        map[x][y] = '.';
                        y -= 1;
                    }
                    map[x][y]= '<';
                }
                else if(command == 'R'){
                    if(y+1<W && map[x][y+1] == '.'){
                        map[x][y] = '.';
                        y += 1;
                    }
                    map[x][y]= '>';
                }
                else if(command == 'S'){
                    if(map[x][y] == '^'){
                        for(int i=x-1; i>=0; i--){
                            if(map[i][y] == '*'){
                                map[i][y] = '.';
                                break;
                            }
                            else if(map[i][y] == '#'){
                                break;
                            }
                        }
                    }
                    else if(map[x][y] == 'v'){
                        for(int i=x+1; i<H; i++){
                            if(map[i][y] == '*'){
                                map[i][y] = '.';
                                break;
                            }
                            else if(map[i][y] == '#'){
                                break;
                            }
                        }
                    }
                    else if(map[x][y] == '<'){
                        for(int j=y-1; j>=0; j--){
                            if(map[x][j] == '*'){
                                map[x][j] = '.';
                                break;
                            }
                            else if(map[x][j] == '#'){
                                break;
                            }
                        }
                    }
                    else if(map[x][y] == '>'){
                        for(int j=y+1; j<W; j++){
                            if(map[x][j] == '*'){
                                map[x][j] = '.';
                                break;
                            }
                            else if(map[x][j] == '#'){
                                break;
                            }
                        }
                    }
                }
            }

            sb.append("#").append(test_case).append(" ");
            for(char[] arr : map){
                for(char c : arr){
                    sb.append(c);
                }
                sb.append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
