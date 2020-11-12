class Solution {
    /*
    StringBuilder 사용법 공부
    StringBuilder.setCharAt(int index, char ch) : index에 있는 문자를 ch 문자로 바꿔주는 함수
    
    Level 1 : 핸드폰 번호 가리기
    */
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder(phone_number);
        for(int i=0; i<phone_number.length()-4; i++){
            sb.setCharAt(i, '*');
        }
        return sb.toString();
    }
    
    // 다른 사람 코드
    // String.toCharArray() : String을 char배열로 변환해주는 함수
    public String solution(String phone_number) {
        char[] ch = phone_number.toCharArray();
        for(int i = 0; i < ch.length - 4; i ++){
            ch[i] = '*';
        }
        return String.valueOf(ch);
    }
}