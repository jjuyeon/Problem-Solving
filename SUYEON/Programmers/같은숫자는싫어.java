import java.util.*;

public class Solution {
    /*
    배열
    Level 1 : 같은 숫자는 싫어
    */
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int prev = -1;
        for(int i=0; i<arr.length; i++){
            if(prev != arr[i]){
                list.add(arr[i]);
                prev = arr[i];
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}