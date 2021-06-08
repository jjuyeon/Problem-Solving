import java.util.*;

class Solution {
    /*
    2020 카카오 인턴십
    Level 1 : 키패드 누르기
    
    풀이 방법 _ 좌표 이용
    열: 나누기 3 , 행: 나머지 3
    */
    public String solution(int[] numbers, String hand) {
        int left = 10, right = 12;
        String answer = "";
        
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] == 0)
                numbers[i] = 11;
            
            if(numbers[i] % 3 == 1){ // left
                left = numbers[i];
                answer += "L";
            }
            else if(numbers[i] % 3 == 0){ // right
                right = numbers[i];
                answer += "R";
            }else{
                int leftTimes = Math.abs((numbers[i]-1)/3 - (left-1)/3) + Math.abs((numbers[i]-1)%3 - (left-1)%3);
                int rightTimes = Math.abs((numbers[i]-1)/3 - (right-1)/3) + Math.abs((numbers[i]-1)%3 - (right-1)%3);
                
                if(leftTimes < rightTimes){
                    left = numbers[i];
                    answer += "L";
                }else if(leftTimes > rightTimes){
                    right = numbers[i];
                    answer += "R";
                }else{
                    if(hand.equals("left")){
                        left = numbers[i];
                        answer += "L";
                    }else{
                        right = numbers[i];
                        answer += "R";
                    }
                }
            }
        }
        return answer;
    }
}