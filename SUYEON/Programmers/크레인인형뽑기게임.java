import java.util.*;
class Solution {
    /*
    2019 카카오 개발자 겨울 인턴십
    Level 1 : 크레인 인형뽑기 게임
    */
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for(int i=0; i<moves.length; i++){
            int now = moves[i] - 1; // 배열의 인덱스는 1이 아닌 0부터 시작하므로
            for(int j=0; j<board.length; j++){
                if(board[j][now] != 0){
                    if(stack.isEmpty()){ // 스택이 비어있다면
                       stack.push(board[j][now]); 
                    }else{ // 스택에 인형 존재하면
                        int top = stack.peek();
                        if(board[j][now] == top){ // 연속해서 같은 인형이라면
                            answer += 2;
                            stack.pop(); // 스택에서 없앤다
                        }else{
                            stack.push(board[j][now]);
                        }
                    }
                    board[j][now] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}