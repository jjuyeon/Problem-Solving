// 효율성관련 부분이 존재한다면 라이브러리, 컬렉션으로의 변환으로 처리하지 않고 순수 배열로써 처리해봄이 통과하는데 있어서도 바람직해보인다.
import java.util.*;

class Solution {
    /*
    스택/큐
    Level 2 : 주식가격
    */
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0; i<prices.length; i++){
            boolean isContinue = true;
            for(int j=i+1; j<prices.length; j++){
                if(prices[j] < prices[i]){
                    answer[i] = j-i;
                    isContinue = false;
                    break;
                }
            }
            if(isContinue){
                answer[i] = prices.length -1 -i;
            }
        }
        
        return answer;
    }
}