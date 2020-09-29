#include <iostream>

using namespace std;

// 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
int main(void){
	// 첫째 줄에 N (1<=N<=100)이 주어진다.
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