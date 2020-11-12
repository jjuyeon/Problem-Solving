import java.util.*;

class Solution {
    /*
    Level 1 : 서울에서 김서방 찾기
    */
    public String solution(String[] seoul) {
        // int idx = 0;
        // for(idx=0; idx<seoul.length; idx++){
        //     if(seoul[idx].equals("Kim"))
        //         break;
        // }
        
        // Arrays.asList(배열) : array를 list로 변환해주는 함수
        int idx = Arrays.asList(seoul).indexOf("Kim");
        String answer = "김서방은 " + idx + "에 있다";
        return answer;
    }
}