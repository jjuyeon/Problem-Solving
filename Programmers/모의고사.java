import java.util.*;

class Solution {
    /*
    완전탐색
    Level 1 : 모의고사
    */
    public int[] solution(int[] answers) {
        int[] person1 = {1,2,3,4,5};
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] correct = new int[3];
        
        for(int i=0; i<answers.length; i++){
            if(person1[i%5] == answers[i])
                correct[0]++;
            if(person2[i%8] == answers[i])
                correct[1]++;
            if(person3[i%10] == answers[i])
                correct[2]++;
        }
        
        int max = Math.max(correct[0], Math.max(correct[1], correct[2]));
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<3; i++){
            if(correct[i] == max)
                list.add(i+1);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        
        return answer;
    }
}