import java.util.*;

class Solution {
    /*
    2018 KAKAO BLIND RECRUITMENT
    Level 1 : [1차] 다트 게임
    */
    public int solution(String dartResult) {
        char[] dartArr = dartResult.toCharArray();
        int[] score = new int[3];
        int scoreIdx = -1;
        
        for(int i=0; i<dartArr.length; i++){
            if('0' <= dartArr[i] && dartArr[i] <= '9'){
                scoreIdx++; // 기준이 되는 인덱스를 나타냄
                if(dartArr[i] == '1' && dartArr[i+1] == '0'){
                    score[scoreIdx] = 10;
                    i++;
                }else{
                    score[scoreIdx] = dartArr[i] - '0';
                }
            }
            else if(dartArr[i] == 'D'){
                score[scoreIdx] = score[scoreIdx] * score[scoreIdx];
            }
            else if(dartArr[i] == 'T'){
                score[scoreIdx] = score[scoreIdx] * score[scoreIdx] * score[scoreIdx];
            }
            else if(dartArr[i] == '#'){
                score[scoreIdx] = -score[scoreIdx];
            }
            else if(dartArr[i] == '*'){
                score[scoreIdx] = score[scoreIdx] * 2;
                if(1 <= scoreIdx){
                    score[scoreIdx - 1] = score[scoreIdx - 1] * 2;
                }
            }
        }
        return score[0] + score[1] + score[2];
    }
}