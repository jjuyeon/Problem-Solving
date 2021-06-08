class Solution {
    /*
    문자열
    Level 1 : 가운데 글자 가져오기
    */
    public String solution(String s) {
        String answer = "";
        
        int len = s.length();
        if(len % 2 == 0){ // 짝수
            answer = s.substring(len/2-1, len/2+1);
        }else{
            answer = s.substring(len/2, len/2+1);
        }
        return answer;
    }
    
    // 다른 사람 코드(한줄 ㄷㄷ)
    public String solution(String s) {
        return s.substring((s.length()-1)/2, s.length()/2 + 1);    
    }
}