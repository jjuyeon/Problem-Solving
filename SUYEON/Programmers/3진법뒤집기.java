class Solution {
    /*
    월간 코드 챌린지 시즌1
    Level 1 : 3진법 뒤집기
    */
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n != 0){ // 뒤집힌 상태로 만들어줌
            sb.append(n % 3);
            n = n / 3;
        }
        
        int answer = 0;
        String str = sb.toString();
        for(int i=0; i<str.length(); i++){
            answer += (str.charAt(str.length() - i -1) - '0') * Math.pow(3, i);
        }
        return answer;
    }
}