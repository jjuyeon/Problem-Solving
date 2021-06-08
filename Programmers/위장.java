import java.util.*;

class Solution {
    /*
    해시
    Level 2 : 위장
    */
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        for(int value : map.values()){
            answer *= (value+1); // +1 하는 이유? 해당 의상 종류 안입는 경우 포함하려고
        }
        
        return (answer-1); // -1 하는 이유? 모든 옷 다 안입는 경우는 빼야함
    }
}