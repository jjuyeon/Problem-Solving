#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <ctype.h>

// �׷� �ܾ�� �ܾ �����ϴ� ��� ���ڿ� ���ؼ�, �� ���ڰ� �����ؼ� ��Ÿ���� ��츸�� ���Ѵ�.
// �ܾ� N���� �Է����� �޾� �׷� �ܾ��� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
int main(void){
	
	char input[100];
	int N=0, i=0, j=0, size=0;
	int alphabet_check[26]={0};
	int word_count = 0;

	// ù°�ٿ� �ܾ��� ���� N�� �Է��Ѵ�. (N�� 100���� ���� �ڿ���)
	scanf("%d", &N);
	getchar(); // ���۸� �����.

	for(i=0; i<N; i++){
		// �ʱ⼼��
		size=0;
		for(j=0; j<26; j++){
			alphabet_check[j] = 0;
		}

		// �ܾ�� ��� �ҹ����̸� �ߺ����� �ʴ´�. �ܾ��� ���̴� �ִ� 100�̴�.		
		scanf("%s", input);
		while(input[size]!='\0'){
		input[size]=tolower(input[size]);
		size++;
		}
		
		for(j=1; j<size; j++){
			int index1 = input[j-1] - 97;
			int index2 = input[j] - 97;
			if((input[j-1] != input[j])){
				if((alphabet_check[index1] == 1) || (alphabet_check[index2] == 1)){ // j-1 �Ǵ� j �ε����� ���� �̹� ���� ���� ������
					word_count++; // �׷� �ܾ �ƴ�
					break;
				}else if(alphabet_check[index1] == 0){ // j-1 �ε��� ���� ���� ���� ������
					alphabet_check[index1] = 1; // ����ߴٰ� üũ
				}
			}
		}
		getchar(); // ���۸� �����.
	}

	printf("%d", N-word_count);

	return 0;
}