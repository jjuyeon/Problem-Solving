class Solution {
    public String solution(int a, int b) {
        /*
        윤년은 4년에 한 번 돌아오는 2월의 끝이 28 -> 29일이 되는 년도
        Level 1 : 2016년
        */
        
        // 2016년 1월 1일은 금요일(start가 "FRI")
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int sum = -1; // -1을 안하면 1월 1일도 하루 지난걸로 계산해서 1월 1일이 금요일이 아니라 토요일이 되므로
        for(int i=0; i<(a-1); i++)
            sum += months[i];
        sum += b;
        
        int ansIndex = sum % 7;
        
        String answer = days[ansIndex];
        return answer;
    }
}