class Solution {
    /*
    Level 1 : 시저 암호
    */
    public String solution(String s, int n) {
        String answer = "";
        char start;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch != ' '){
                start = (Character.isLowerCase(ch)) ? 'a' : 'A'; 
                ch = (char) (start + (ch - start + n) % 26); // start + 변화량
                
            }
            answer += ch;
        }
        return answer;
    }
}