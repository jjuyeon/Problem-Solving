class Solution {
    /*
    Level 1 : 평균 구하기
    */
    public double solution(int[] arr) {
        double answer = 0;
        for(int num : arr)
            answer += num;
        
        answer = (double)answer / arr.length;
        return answer;
    }
}