class Solution {
    public int solution(String s) {
        int strLen = s.length();
        int answer = strLen; // �ִ���̴� ���ڿ��� ����������
        
        // ���� ���ڿ��� ���̿� �� �̻��� ������̷� �ϸ� �ߺ��̴� (�׷����� �ٷ� �˼��ִ�)
        for(int len=1; len<=strLen/2; len++){
            String prev = s.substring(0,len); // �� ���ڿ� ����(�� �պ��� �Ľ̵� ���ڿ�)
            // i: ���ڿ� �ε���, totalCnt: len�� �°� ����� ���ڿ� ����, prevCnt: �� ���ڿ��� ��ġ�ϴ� ���ڿ��� ����
            int i=len, totalCnt = 0, prevCnt = 1; 
            
            while(true){
                String now = s.substring(i, i+len); // ���� �Ľ̵� ���ڿ�
                
                if(prev.equals(now)) ++prevCnt; // �� ���ڿ��� ��ġ�ϸ� ���� ������Ʈ
                
                else{ // ����ġ�̸� �� ���ڿ��� ���� ���ڿ��� ������Ʈ�������
                    totalCnt += len; // �� ���ڿ��� ���̴� �׻� len�̴�
                    if(prevCnt > 1) totalCnt += String.valueOf(prevCnt).length(); // �� ���ڿ��� ��ġ�ϴ� ���ڿ��� 1�� �̻� �������� �տ� ���� ������Ѵ�
                    prev = now; // prev(�� ���ڿ�)�� ���� ���ڿ��� ������Ʈ
                    prevCnt = 1; // �� ���ڿ��� ��ġ�ϴ� ���ڿ��� ���� ���ڿ��ۿ� ����
                }
                
                int checkLen = i + len; // ������ �Ѿ���� üũ�ϱ� ����
                if(checkLen > strLen - len){ // ������ �Ѿ�� ���̻� �Ľ� �Ұ���
                    totalCnt += (strLen-i); // �ڿ� �����ִ� ���ڿ� ���� ������
                    if(prevCnt > 1){
                        totalCnt += String.valueOf(prevCnt).length();
                    }
                    break;
                }
                else{ // ���� �ȳѾ��
                    i += len; // ��� ������
                }
            }

            answer = Math.min(answer, totalCnt);
        }
        
        return answer;
    }
}
