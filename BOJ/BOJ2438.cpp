#include <iostream>

using namespace std;

// ù° �ٿ��� �� 1��, ��° �ٿ��� �� 2��, N��° �ٿ��� �� N���� ��� ����
int main(void){
	// ù° �ٿ� N (1<=N<=100)�� �־�����.
	int N;
	cin>>N;

	if(1<=N && N<=100){
		for(int i=0; i<N; i++){
			for(int j=0; j<i+1; j++){
				cout<<"*";
			}
			cout<<"\n";
		}
	}
	return 0;
}