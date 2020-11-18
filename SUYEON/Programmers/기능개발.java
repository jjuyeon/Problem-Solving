import java.util.*;

class Solution {
    /*
    스택/큐
    Level 2 : 기능개발
    */
    public int[] solution(int[] progresses, int[] speeds) {        
        List<Integer> list = new ArrayList<>();
        int prevDay = -1, day = 0;
        int release = 0;
        for(int i=0; i<progresses.length; i++){
            int nowProgress = progresses[i] + speeds[i] * day;
            while(nowProgress < 100){
                nowProgress += speeds[i];
                day++;
            }
            if(prevDay != -1 && prevDay != day){
                list.add(release);
                release = 0;
            }
            prevDay = day;
            release++;
        }
        list.add(release);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        
        return answer;
    }
}

import java.util.*;
class Solution {
    // 다른 사람 코드 : 한끝차이!! (stream에서 filter와 toArray 정도는 공부하자!)
    public int[] solution(int[] progresses, int[] speeds) {        
        int[] dayOfEnd = new int[100];
        int day = 0;
        for(int i=0; i<progresses.length; i++){
            int nowProgress = progresses[i] + speeds[i] * day;
            while(nowProgress < 100){
                nowProgress += speeds[i];
                day++;
            }
            dayOfEnd[day]++;
        }
        
        return Arrays.stream(dayOfEnd).filter(i->i!=0).toArray();
    }
}