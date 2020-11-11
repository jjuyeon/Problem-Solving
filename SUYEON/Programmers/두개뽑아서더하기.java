import java.util.*;

class Solution {
    /*
        월간 코드 챌린지 시즌1
        Level 1 : 두 개 뽑아서 더하기
    */
    public int[] solution(int[] numbers) {
        ArrayList<Integer> arrList = new ArrayList<>();
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                int sum = numbers[i] + numbers[j];
                if(!arrList.contains(sum))
                    arrList.add(sum);
            }
        }
        
        Collections.sort(arrList);
        
        int[] answer = new int[arrList.size()];
        for(int i=0; i<arrList.size(); i++)
            answer[i] = arrList.get(i);
        
        return answer;
    }
}