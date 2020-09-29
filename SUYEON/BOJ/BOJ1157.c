#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <ctype.h>

typedef unsigned char Bool;
#define true 1
#define false 0

//알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
//첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
int main(void){
	char input[1000000];
	int i=0, j=0;
	int maximum_index = 0;
	Bool check  = false;	
	//result 배열
	char alphabet[26]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	int result[26]={0};

	//단어 입력
	scanf("%s", input);

	//모두 대문자로 변환	
	while(input[i]!='\0'){
	 input[i]=toupper(input[i]);
	 i++;
	}

	//알파벳 빈도수 측정
	for(i=0; input[i]!='\0'; i++){
		for(j=0; j<26; j++){
			if(input[i] == 'A'+j){
				result[j]+=1;
			}
		}
	}

	//가장 많이 사용된 알파벳 확인(sorting)
	for(i=0; i<26; i++){
		for(j=i; j<26; j++){
			if(result[i]>result[j]){
				int temp = result[i];
				char temp2 = alphabet[i];
				result[i] = result[j];
				result[j] = temp;
				alphabet[i] = alphabet[j];
				alphabet[j] = temp2;
			}
		}
	}
	
	//만약 많이 사용된 알파벳이 여러 개인 경우
	if(result[25] == result[24]){
		printf("?");
	}
	//아닌 경우
	else{
		printf("%c",alphabet[25]);
	}

	return 0;
}