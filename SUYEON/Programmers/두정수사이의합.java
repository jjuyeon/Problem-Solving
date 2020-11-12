class Solution {
    /*
    Level 1 : 두 정수 사이의 합
    */
    public long solution(int a, int b) {
        return sumAB(Math.min(a,b), Math.max(a,b));
    }
    
    public long sumAB(int a, int b){
        long answer = 0;
        for(int i=a; i<=b; i++){
            answer += i;
        }
        return answer;
    }
}