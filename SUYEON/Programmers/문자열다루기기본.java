class Solution {
    /*
    Level 1 : 문자열 다루기 기본
    */
    public boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        if(len == 4 || len == 6){
            for(int i=0; i<len; i++){
                if(s.charAt(i) >= 'a'){
                    answer = false;
                    break;
                }
            }
        }else{
            answer = false;
        }
        
        return answer;
    }
    
    // 다른 사람 코드 : try catch를 사용해서 exception 에러가 나면 false를 반환하도록!!
    public boolean solution(String s) {
      if(s.length() == 4 || s.length() == 6){
          try{
              int x = Integer.parseInt(s);
              return true;
          } catch(NumberFormatException e){
              return false;
          }
      }
      else return false;
  }
}