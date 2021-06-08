import java.util.*;

class Solution {
    /*
    해시
    Level 2 : 전화번호 목록
    */
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book); // 오름차순
        
        // 접두사 판단하는 것이기 때문에 contains 사용하면 안됨 ex) ["222", "111", "332223"]
        // for(int i=0; i<phone_book.length-1; i++){
        //     if(phone_book[i+1].contains(phone_book[i])){
        //         answer = false;
        //         break;
        //     }
        // }
        
        // boolean startsWith(String prefix)
        // - startsWith() 함수는 대상 문자열이 특정 문자 또는 문자열로 시작하는지 체크하는 함수
        // - 해당 문자열로 시작되는지 여부를 확인하고 boolean 에 맞춰 true/false 값을 리턴
        for(int i=0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        return answer;
    }
}