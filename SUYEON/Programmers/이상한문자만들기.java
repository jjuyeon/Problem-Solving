class Solution {
    /*
    Level 1 : 이상한 문자 만들기
    */
    public String solution(String s) {
        String answer = "";
        String[] strArr = s.split("");
        int idx = 0;
        for(int i=0; i<strArr.length; i++){
            if(strArr[i].equals(" ")){
                idx = 0;
            }else{
                if(idx % 2 == 0){ // 짝수
                    strArr[i] = strArr[i].toUpperCase();
                }else{ // 홀수
                    strArr[i] = strArr[i].toLowerCase();
                }
                idx++;
            }
            answer += strArr[i];
        }
        return answer;
    }
}