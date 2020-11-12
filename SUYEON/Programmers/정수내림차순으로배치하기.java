import java.util.*;

class Solution {
    /*
    Level 1 : 정수 내림차순으로 배치하기
    */
    public long solution(long n) {
        String[] ltos = Long.toString(n).split("");
        Arrays.sort(ltos, Collections.reverseOrder()); // 내림차순
        String tmpAnswer = "";
        for(int i=0; i<ltos.length; i++){
            tmpAnswer += ltos[i];
        }
        return Long.parseLong(tmpAnswer);
    }
}