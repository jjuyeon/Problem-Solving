#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <ctype.h>

// 알파벳 소문자로만 이루어진 단어 S가 주어진다. 
// 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.

int main(void){
	char input[100];
	int i=0, j=0;
	//result 배열
	char alphabet[26]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	int result[26];

	//result -1로 초기화
	for(i=0; i<26; i++){
		result[i] = -1;
	}

	// 단어를 입력 받음
	scanf("%s", input);
	//모두 소문자로 변환	
	while(input[i]!='\0'){
	 input[i]=tolower(input[i]);
	 i++;
	}

	// 단어를 하나씩 입력 받아서 해당되는 알파벳이 어느 인덱스에서 처음 나타나는지 배열에 저장
	for(i=0; input[i]!='\0'; i++){
		for(j=0; j<26; j++){
			if(result[j] == -1 && input[i] == alphabet[j]){
				result[j] = i;
			}
		}
	}

	// 문제의 요구사항에 따라 출력
	for(i=0; i<26; i++){
		printf("%d ",result[i]);
	}

	return 0;
}