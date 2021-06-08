class Solution {  
    /*
    2018 KAKAO BLIND RECRUITMENT
    
    비트 연산자, 
    2진수로 출력: Integer.toBinaryString(int),
    출력 포맷 정해주기: String.format("%s", Stirng s)
    
    Level 1 : [1차] 비밀지도
    */
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            String str = Integer.toBinaryString(arr1[i] | arr2[i]).replace('1','#').replace('0',' ');
            //while(str.length() != n){
            //    str = " " + str;
            //}
            
            // String.format 함수에 대해 배울 수 있었다!
            answer[i] = String.format("%"+n+"s",str);
        }
        return answer;
    }
}