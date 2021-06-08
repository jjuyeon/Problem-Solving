#include <iostream>

using namespace std;

// 숫자 N이 주어졌을 때, 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산하는 프로그램을 작성하시오.
int main(void){
	int N;
	cin>>N;	

	int count = 0; // 지나가는 방의 수를 저장
	int standard = 1;
	for(int i=1; ; i++){
		if(N == 1){
			count = 1;
			break;
		}
		if(N <= standard + 6*i){ // 해당 벌집은 6의 배수로 방이 증가하는 규칙을 가지고 있다.
			count = 1 + i;
			break;
		}else{
			standard += 6*i;
		}
	}
	
	cout<<count;
	return 0;
}