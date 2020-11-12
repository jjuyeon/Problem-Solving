class Solution {
    /*
    Level 1 : 문자열 내 p와 y의 개수
    */
    boolean solution(String s) {
        s = s.toLowerCase();
        int p = 0, y = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'p')
                p++;
            else if(s.charAt(i) == 'y')
                y++;
        }
        
        boolean answer = (p == y)? true : false;
        return answer;
    }
    
    // 다른 사람 코드 : 람다에 대해 공부하자!
    /*
    1) s.chars() : s가 String이므로, s의 각 문자를 IntStream으로 변환해주는 함수 (char 는 문자이지만 본질적으로는 숫자이기 때문에 가능)
    2) filter() : 필터(filter)은 스트림 내 요소들을 하나씩 평가해서 걸러내는 작업
                (e-> 'P' == e) : 즉, 현재 요소가 P와 일치하면 true
    */
    boolean solution(String s) {
        s = s.toUpperCase();

        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
    }
}