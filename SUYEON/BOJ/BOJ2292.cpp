#include <iostream>

using namespace std;

// ���� N�� �־����� ��, ������ �߾� 1���� N�� ����� �ּ� ������ ���� ������ �� �� �� ���� ���� ����������(���۰� ���� �����Ͽ�)�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
int main(void){
	int N;
	cin>>N;	

	int count = 0; // �������� ���� ���� ����
	int standard = 1;
	for(int i=1; ; i++){
		if(N == 1){
			count = 1;
			break;
		}
		if(N <= standard + 6*i){ // �ش� ������ 6�� ����� ���� �����ϴ� ��Ģ�� ������ �ִ�.
			count = 1 + i;
			break;
		}else{
			standard += 6*i;
		}
	}
	
	cout<<count;
	return 0;
}