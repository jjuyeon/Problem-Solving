import java.util.Arrays;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int MAX_VALUE = n*100001; // 1-n까지 직선으로 갈 수 있으면 최대 n*100000 비용이 들 수 있음(그러므로, 아예 갈 수 없으면 더 크게 초기값을 설정해야함)
        int[][] minCost = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            Arrays.fill(minCost[i], MAX_VALUE);
            minCost[i][i] = 0; // 시작점 = 도착점일 땐, 비용이 0이다
        }
        for(int i=0, size=fares.length; i<size; i++){
            int from = fares[i][0];
            int to = fares[i][1];
            minCost[from][to] = minCost[to][from] = fares[i][2];
        }
        
        // floyd
        for(int k=1; k<=n; k++){ // 경
            for(int i=1; i<=n; i++){ // 출
                for(int j=1; j<=n; j++){ // 도
                    if(i!=j){
                        minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
                    }
                }
            }
        }
        
        int answer = MAX_VALUE;
        for(int k=1; k<=n; k++){
            // minCost[s][k] : 공통경로, minCost[k][a] : 공통경로~a까지 경로, minCost[k][b] : 공통경로~b까지 경로
            answer = Math.min(answer, minCost[s][k] + minCost[k][a] + minCost[k][b]);
        }
        return answer;
    }
}
