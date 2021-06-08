#include <iostream>
#include <string>
#include <algorithm>

// 상수는 숫자를 읽는데 문제가 있다. 상근이는 세 자리 숫자 두 개를 칠판에 써주었다. 그 다음에 크기가 큰 수를 말해보라고 했다.
// 상수는 수를 다른 사람과 다르게 거꾸로 읽는다. 두 수가 주어졌을 때, 상수의 대답을 출력하는 프로그램을 작성하시오.

using namespace std;

int main(void){
	// 한번에 세 자리 숫자 2개를 받아온다.
	char input[8];
	cin.getline(input,8,'\n');

	string compare1="";
	string compare2="";

	// 한번에 받은 숫자 2개를 각각의 숫자로 파싱한다.
	bool next = false;
	for(int i=0; input[i]!='\0'; i++){
		if(input[i] == ' '){
			next = true;
			continue;
		}

		if(next){
			compare2 += input[i];
		}else {
			compare1 += input[i];
		}
	}
	
	// 파싱한 숫자 2개를 reverse한다.
	reverse(compare1.begin(), compare1.end());
	reverse(compare2.begin(), compare2.end());

	// reverse된 숫자 2개를 비교하여 출력한다.
	if(compare1.compare(compare2)<0){
		cout<<compare2<<endl;
	}else{
		cout<<compare1<<endl;
	}
	return 0;
}