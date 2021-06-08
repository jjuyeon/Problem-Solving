class Solution {
    /*
    Level 1 : 소수 찾기
    */
    public int solution(int n) {
        boolean[] prime = new boolean[n+1];
        for(int i=2; i<=n; i++)
            prime[i] = true;
        
        for(int i=2; i<=n; i++){
            for(int j=2; j<=(n/i); j++){
                if(prime[i*j])
                    prime[i*j] = false;
            }
        }
        
        int answer = 0;
        for(int i=2; i<=n; i++){
            if(prime[i])
                answer++;
        }
        return answer;
    }
}