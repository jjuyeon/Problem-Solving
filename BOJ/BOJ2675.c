#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

// 문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
int main(void){
	char input[1000];
	char* ptr;
	int R=0, i=0, j=0, k=0, size=0, count;
	char S[21]; //20글자까지 올 수 있음.
	
	// 각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다. 
	scanf("%d", &count);
	getchar(); // 버퍼를 비워줌.

	// 테스트 케이스만큼 반복
	for(k=0; k<count; k++){
	// S의 길이는 적어도 1이며, 20글자를 넘지 않는다. 
	// '%[^\0] -> 엔터를 제외한 모든 문자열을 받을 수 있도록 함.
	scanf("%[^\n]",input);
	
	// 파싱하여 해당되는 변수에 값을 저장한다.
	size=0; // size 초기화
	R = atoi(&input[0]);
	for(i=2; input[i]!='\0'; i++){
		S[size++] = input[i];
	}
	S[size]= '\0';	

	// 문제의 조건에 맞게 반복하여 출력한다.
	for(i=0;S[i]!='\0';i++){
		for(j=0; j<R; j++){
			printf("%c", S[i]);
		}
	}

	printf("\n");
	getchar(); // 버퍼를 비워줌.
	}

	
	
	return 0;
}