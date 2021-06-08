import java.util.*;

class Solution {
    /*
    Level 1 : 문자열 내림차순으로 배치하기
    */
    public String solution(String s) {
        String[] arr = s.split("");
        Arrays.sort(arr, Collections.reverseOrder()); // 내림차순
        
        StringBuilder sb = new StringBuilder();
        for(String str : arr)
            sb.append(str);
        
        return sb.toString();
    }
    
    // 다른 사람 코드 .. 대단하당
    public String solution(String s){
        char[] charArr = s.toCharArray();
        return new StringBuilder(new String(charArr)).reverse().toString();
    }
}