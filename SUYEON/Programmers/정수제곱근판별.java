class Solution {
    /*
    Level 1 : 정수 제곱근 판별
    */
    public long solution(long n) {
        int num = (int) Math.sqrt(n);
        if(Math.pow(num, 2) == n){
            return (long) Math.pow(num+1, 2);
        }
        return -1;
    }
}