import java.util.*;

class Solution {
    /*
    Summber/Winter Coding(~2018)
    Level 1 : 예산
    */
    public int solution(int[] d, int budget) {
        Arrays.sort(d); // 오름차순
        
        int answer = 0;
        for(int i=0; i<d.length; i++){
            budget = budget - d[i];
            if(budget < 0){
                break;
            }
            answer++;
        }
        
        return answer;
    }
}