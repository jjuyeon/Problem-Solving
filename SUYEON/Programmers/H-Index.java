import java.util.*;

class Solution {
    /*
    정렬
    Level 2 : H-Index
    */
    public int solution(int[] citations) {
        Arrays.sort(citations); // 오름차순

        for(int i=0; i<citations.length; i++){
            int h = citations.length - i;
            if(h <= citations[i]){
                return h;
            }
        }
        return 0;
    }
}