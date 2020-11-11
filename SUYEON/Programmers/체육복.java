import java.util.*;

class Solution {
    /*
    탐욕법(Greedy)
    Level 1 : 체육복
    */
    public int solution(int n, int[] lost, int[] reserve) {
        int[] haveClothes = new int[n+1];
        Arrays.fill(haveClothes, 1);
        haveClothes[0] = -1; // 필요한 인덱스는 1부터 시작하므로
        
        for(int val : reserve){
            haveClothes[val]++;
        }
        for(int val : lost){
            haveClothes[val]--;
        }
        
        for(int val : lost){
            if(!checkReserve(val, reserve)){ // 여유분 있는 사람 != 도난 당한 사람 (이때만 왼쪽, 오른쪽 확인)
                int left = val - 1;
                int right = val + 1;

                if(left >= 1 && haveClothes[left] > 1){ // 왼쪽 사람이 여유분이 있다면
                    haveClothes[val]++;
                    haveClothes[left]--;
                }else if(right <= n && haveClothes[right] > 1){ // 오른쪽 사람이 여유분이 있다면
                    haveClothes[val]++;
                    haveClothes[right]--;
                }
            }
        }
        
        int answer = 0;
        for(int val : haveClothes){
            if(val >= 1){
                answer++;
            }
        }
        return answer;
    }
    
    public boolean checkReserve(int val, int[] reserve){
        for(int tmp : reserve){
            if(val == tmp)
                return true;
        }
        return false;
    }
}