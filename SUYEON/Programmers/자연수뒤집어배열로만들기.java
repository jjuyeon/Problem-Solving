import java.util.*;

class Solution {
    /*
    Level 1 : 자연수 뒤집어 배열로 만들기
    */
    public int[] solution(long n) {
        List<Integer> list = new ArrayList<>();
        while(n > 0){
            int remain = (int) (n % 10);
            list.add(remain);
            n = n/10;
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}