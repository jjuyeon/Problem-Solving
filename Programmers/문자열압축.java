class Solution {
    public int solution(String s) {
        int strLen = s.length();
        int answer = strLen; // 최대길이는 문자열의 원래길이임
        
        // 기존 문자열의 길이에 반 이상을 압축길이로 하면 중복이다 (그려보면 바로 알수있다)
        for(int len=1; len<=strLen/2; len++){
            String prev = s.substring(0,len); // 비교 문자열 설정(맨 앞부터 파싱된 문자열)
            // i: 문자열 인덱스, totalCnt: len에 맞게 압축된 문자열 길이, prevCnt: 비교 문자열과 일치하는 문자열의 개수
            int i=len, totalCnt = 0, prevCnt = 1; 
            
            while(true){
                String now = s.substring(i, i+len); // 현재 파싱된 문자열
                
                if(prev.equals(now)) ++prevCnt; // 비교 문자열과 일치하면 갯수 업데이트
                
                else{ // 불일치이면 비교 문자열을 현재 문자열로 업데이트해줘야함
                    totalCnt += len; // 비교 문자열의 길이는 항상 len이다
                    if(prevCnt > 1) totalCnt += String.valueOf(prevCnt).length(); // 비교 문자열과 일치하는 문자열이 1번 이상 나왔으면 앞에 숫자 써줘야한다
                    prev = now; // prev(비교 문자열)를 현재 문자열로 업데이트
                    prevCnt = 1; // 비교 문자열과 일치하는 문자열은 현재 문자열밖에 없다
                }
                
                int checkLen = i + len; // 범위가 넘어가는지 체크하기 위함
                if(checkLen > strLen - len){ // 범위가 넘어가면 더이상 파싱 불가능
                    totalCnt += (strLen-i); // 뒤에 남아있는 문자열 길이 더해줌
                    if(prevCnt > 1){
                        totalCnt += String.valueOf(prevCnt).length();
                    }
                    break;
                }
                else{ // 범위 안넘어가면
                    i += len; // 계속 진행함
                }
            }

            answer = Math.min(answer, totalCnt);
        }
        
        return answer;
    }
}
