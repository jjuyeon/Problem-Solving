import java.util.*;

class Map1725 {
    int index;
    int height;

    Map1725(int i, int h){
        this.index = i;
        this.height = h;
    }
}

public class BOJ1725 { // using stack
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Stack<Map1725> stack = new Stack<>();
        int n = sc.nextInt();
        long answer = 0;
        for(int i=0; i<n; i++){ // 히스토그램 전체 순회
            int now_height = sc.nextInt();

            if(stack.isEmpty()){ // 스택이 비어있으면 그냥 push
                stack.push(new Map1725(i, now_height));
                continue;
            }

            if(stack.peek().height <= now_height){ // 현재 높이가 더 크다면 더 큰 직사각형을 만들 가능성이 있으므로 push
                stack.push(new Map1725(i, now_height));
            }else{
                int minIndex = 0;
                // 현재 높이가 더 작다면 스택에서 빼서 현재 그릴 수 있는 최대 사각형의 넓이를 저장해둔다
                while(!stack.isEmpty() && (stack.peek().height > now_height)){
                    Map1725 top = stack.pop();
                    answer = Math.max(answer, (i-top.index) * top.height);
                    minIndex = top.index;
                }
                // 넓이 업데이트가 끝나면 현재 높이를 스택에 push
                stack.push(new Map1725(minIndex, now_height));
            }
        }

        // 전체 순회가 끝난 후에도 stack에 정보가 남아있다면 다 빼서 최대 넓이를 업데이트
        while(!stack.isEmpty()){
            Map1725 top = stack.pop();
            answer = Math.max(answer, (n-top.index) * top.height);
        }

        System.out.print(answer);
    }
}
