class Solution {
    /*
    Level 1 : 콜라츠 추측
    */
    public int solution(int num) {
        long itol = (long)num;
        int answer = 0;
        for(int i=0; i<500; i++){
            if(itol == 1){
                return answer;
            }
            if(itol % 2 == 0){ // 짝수
                itol /= 2;
            }else{ // 홀수
                itol = itol*3 + 1;
            }
            answer++;
        }
        
        return -1;
    }
}

// 다른 사람 코드 : 재귀로도 짤 수 있었다!! 신기방기
class Solution {
    int answer=0;
  public int solution(int num) {
      if(num == 1){
            return answer;
        }
        if(answer==500){
            return -1;
        }
        answer++;
        if (num % 2 == 1) {
            // 홀수
            return solution(num * 3 + 1);
        } else{
            // 짝수
            return solution(num / 2);
        } 
  }
}
