#include <iostream>
#include <cctype>
// 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
// 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
int main(void){
	
	char input[100];
	int N=0, i=0, j=0;
	int word_count = 0;

	// 첫째줄에 단어의 개수 N을 입력한다. (N은 100보다 작은 자연수)
	std::cin>>N;
	getchar(); // 버퍼를 비워줌.

	for(i=0; i<N; i++){
		// 초기세팅
		int size=0;
		int alphabet_check[26] = {0};

		// 단어는 모두 소문자이며 중복되지 않는다. 단어의 길이는 최대 100이다.		
		std::cin.getline(input,100);

		while(input[size]!='\0'){
		input[size]=tolower(input[size]);
		size++;
		}
		
		// 인덱스 j-1의 값과 인덱스 j의 값을 비교하여 그룹 단어인지 아닌지를 판단
		for(j=1; j<size; j++){
			int index1 = input[j-1] - 97;
			int index2 = input[j] - 97;
			if((input[j-1] != input[j])){
				if((alphabet_check[index1] == 1) || (alphabet_check[index2] == 1)){ // j-1 또는 j 인덱스의 값이 이미 사용된 적이 있으면
					word_count++; // 그룹 단어가 아님
					break;
				}else if(alphabet_check[index1] == 0){ // j-1 인덱스 값이 사용된 적이 없으면
					alphabet_check[index1] = 1; // 사용했다고 체크
				}
			}
		}
	}

	std::cout<<(N-word_count);

	return 0;
}