class Solution {
    /*
    Level 1 : 짝수와 홀수
    */
    public String solution(int num) {
        String answer = (num % 2 == 0)? "Even" : "Odd";
        return answer;
    }
}