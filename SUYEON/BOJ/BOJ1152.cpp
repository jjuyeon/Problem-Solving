#include <iostream>
#include <cctype>

// 영어 대소문자와 띄어쓰기만으로 이루어진 문자열이 주어진다. 이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오.
int main(void){
	
	// 첫 줄에 영어 대소문자와 띄어쓰기로 이루어진 문자열이 주어진다. 이 문자열의 길이는 1,000,000을 넘지 않는다. 
	// 단어는 띄어쓰기 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다. 또한 문자열의 앞과 뒤에는 공백이 있을 수도 있다.
	char input[1000000];
	std::cin.getline(input,1000000,'\n');

	int count = 0; // 단어의 개수를 저장하는 변수
	bool word = true; // 단어임을 체크하는 변수
	for(int i=0; input[i]!='\0'; i++){
		if(input[i] == ' '){ //공백문자가 나오면 단어임을 체크
			word = true;
		}else if(word){ //만약 단어라면
			count++; 
			word = false;
		}
	}

	std::cout<<count;

	return 0;
}