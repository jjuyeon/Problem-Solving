import java.util.*;

class Solution {
    /*
    해시 사용 O(n)
    Level 1 : 완주하지 못한 선수
    */
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String person : participant){
            if(map.get(person) == null){ // 처음 나오는 경우
                map.put(person, 1);
            }else{ // 이미 나왔던 경우
                int value = map.get(person) + 1;
                map.put(person, value);
            }
        }
        
        for(String person : completion){
            int value = map.get(person);
            map.put(person, value-1);
        }
        
        String answer = "";
        for(String key : map.keySet()){
            if(map.get(key) == 1)
                answer = key;
        }
        
        return answer;
    }
    
    public String solution(String[] participant, String[] completion) {
        /* 
        해시 사용 안하고 간단하게 풀 수 있는 방법
        각 배열을 정렬하여
        비교하면서 값이 일치하지 않는 인덱스의 값을 return하면 됨
        단 시간 복잡도가 O(n) -> O(nLogN) ~ O(n2) 으로 늘어남
        */
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int idx = 0;
        for(idx=0; idx<completion.length; idx++){
            if(!participant[idx].equals(completion[idx])){
                return participant[idx];
            }
        }
        return participant[idx];
    }
}