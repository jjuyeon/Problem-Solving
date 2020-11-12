import java.util.*;

class Solution {
    /*
    Level 1 : 제일 작은 수 제거하기
    */
    public int[] solution(int[] arr) {
        if(arr.length == 1){
            int[] answer = {-1};
            return answer;
        }
        
        int min = arr[0];
        for(int i=1; i<arr.length; i++){
            min = Math.min(min, arr[i]);
        }
        int idx = 0;
        int[] answer = new int[arr.length-1];
        for(int i=0; i<arr.length; i++){
            if(arr[i] == min)
                continue;
            answer[idx++] = arr[i];
        }
        return answer;
    }
}