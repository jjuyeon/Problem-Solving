class Solution {
    public int[] solution(int n, int m) {
        /*
        !외워두기!
        Study about '유클리드 호제법'
        ★ Level 1 : 최대공약수와 최소공배수 ★
        */
        
        int a = Math.max(n,m);
        int b = Math.min(n,m);
        
//         while(b > 0){
//             int tmp = a%b;
//             a = b;
//             b = tmp;
//         }
        
//         gcd = a;
//         lcm = (n*m) / a;
        
        int gcd = getGCD(a , b);
        int lcm = (n*m) / gcd;
        
        int[] answer = {gcd, lcm};
        return answer;
    }  
    
    // 다른 사람 코드(유클리드 호제법) 재귀로도 풀 수 있다!
    public int getGCD(int a, int b)
    {
        if (b == 0) return a;
        return getGCD(b, a%b);
    }
}