import java.util.*;

class Stage implements Comparable<Stage> {
    int number;
    double failure;
    public Stage(int number, double failure){
        this.number = number;
        this.failure = failure;
    }
    
    @Override
    public int compareTo(Stage s){
        if(this.failure == s.failure){
            return (this.number > s.number) ? 1 : -1; // 스테이지는 작은 순으로 정렬
        }else{
            return (this.failure > s.failure) ? -1 : 1; // 실패율은 높은 순으로 정렬
        }
    }
}

class Solution {
    /*
    2019 KAKAO BLIND RECRUITMENT
    Level 1 : 실패율
    */
    public int[] solution(int N, int[] stages) {
        ArrayList<Stage> stageList = new ArrayList<>();
        for(int i=1; i<=N; i++){
            int total = 0;
            int stop = 0;
            
            for(int j=0; j<stages.length; j++){
                if(stages[j] >= i){
                    total++;
                }
                if(stages[j] == i){
                    stop++;
                }
            }
            if(total == 0){
                stageList.add(new Stage(i, 0));
            }else{
                stageList.add(new Stage(i, (double) stop/total));
            }
        }
        
        Collections.sort(stageList);
        
        int[] answer = new int[N];
        for(int i=0; i<N; i++)
            answer[i] = stageList.get(i).number;
        
        return answer;
    }
}