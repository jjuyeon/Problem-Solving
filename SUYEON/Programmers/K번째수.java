import java.util.*;

class Solution {
    /*
    정렬
    Level 1 : K번째수
    */
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answer_i = 0;
        
        for(int i=0; i<commands.length; i++){
            int start = commands[i][0] - 1; // 배열의 인덱스는 1이 아닌 0으로 시작하므로 -1
            int end = commands[i][1] - 1;
            int k = commands[i][2] - 1;
            
            int[] tempArr = Arrays.copyOfRange(array, start, end + 1);
            Arrays.sort(tempArr); // 오름차순
            answer[answer_i++] = tempArr[k];
        }
        return answer;
    }
}