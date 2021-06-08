import java.util.*;

class Solution {
    /*
    Level 1 : 나누어 떨어지는 숫자 배열
    */
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for(int val : arr){
            if(val % divisor == 0){
                list.add(val);
            }
        }
        
        if(list.size() == 0){
            list.add(-1);
        }else{
            Collections.sort(list); // 오름차순
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }
}