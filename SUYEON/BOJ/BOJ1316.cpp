#include <iostream>
#include <cctype>
// �׷� �ܾ�� �ܾ �����ϴ� ��� ���ڿ� ���ؼ�, �� ���ڰ� �����ؼ� ��Ÿ���� ��츸�� ���Ѵ�.
// �ܾ� N���� �Է����� �޾� �׷� �ܾ��� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
int main(void){
	
	char input[100];
	int N=0, i=0, j=0;
	int word_count = 0;

	// ù°�ٿ� �ܾ��� ���� N�� �Է��Ѵ�. (N�� 100���� ���� �ڿ���)
	std::cin>>N;
	getchar(); // ���۸� �����.

	for(i=0; i<N; i++){
		// �ʱ⼼��
		int size=0;
		int alphabet_check[26] = {0};

		// �ܾ�� ��� �ҹ����̸� �ߺ����� �ʴ´�. �ܾ��� ���̴� �ִ� 100�̴�.		
		std::cin.getline(input,100);

		while(input[size]!='\0'){
		input[size]=tolower(input[size]);
		size++;
		}
		
		// �ε��� j-1�� ���� �ε��� j�� ���� ���Ͽ� �׷� �ܾ����� �ƴ����� �Ǵ�
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
	}

	std::cout<<(N-word_count);

	return 0;
}