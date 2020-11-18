import java.util.*;

class Solution {
    /*
    정렬
    Level 2 : 가장 큰 수
    */
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            arr[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                /*
                 정렬하고자 하는 배열의 '뒤의 값'이 '첫 번째 인자 값'으로 들어오고, '앞의 값'이 '두 번째 인자 값'으로 들어온다는 걸 잊지말자
                  음수를 리턴할 경우 입력순서 바꿈
                  양수, 0을 리턴할 경우 입력순서 유지
                */
                return -(Integer.parseInt(a+b) - Integer.parseInt(b+a));
            } // 내림차순
        }); 
        
        if(arr[0].equals("0")){
            return "0";
        }
        
        String answer = "";
        for(int i=0; i<numbers.length; i++){
            answer+=arr[i];
        }
        return answer;
    }
}