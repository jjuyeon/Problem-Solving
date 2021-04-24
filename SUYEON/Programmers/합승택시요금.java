import java.util.Arrays;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int MAX_VALUE = n*100001; // 1-n���� �������� �� �� ������ �ִ� n*100000 ����� �� �� ����(�׷��Ƿ�, �ƿ� �� �� ������ �� ũ�� �ʱⰪ�� �����ؾ���)
        int[][] minCost = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            Arrays.fill(minCost[i], MAX_VALUE);
            minCost[i][i] = 0; // ������ = �������� ��, ����� 0�̴�
        }
        for(int i=0, size=fares.length; i<size; i++){
            int from = fares[i][0];
            int to = fares[i][1];
            minCost[from][to] = minCost[to][from] = fares[i][2];
        }
        
        // floyd
        for(int k=1; k<=n; k++){ // ��
            for(int i=1; i<=n; i++){ // ��
                for(int j=1; j<=n; j++){ // ��
                    if(i!=j){
                        minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
                    }
                }
            }
        }
        
        int answer = MAX_VALUE;
        for(int k=1; k<=n; k++){
            // minCost[s][k] : ������, minCost[k][a] : ������~a���� ���, minCost[k][b] : ������~b���� ���
            answer = Math.min(answer, minCost[s][k] + minCost[k][a] + minCost[k][b]);
        }
        return answer;
    }
}
