#define _CRT_SECURE_NO_WARNINGS //scanf() 오류를 방지하기 위한 상수 정의
#include <stdio.h>

//알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.
int main(void){
	int ASCII_result = 0;
	char input;
	scanf("%c",&input);
	ASCII_result = (int)input;
	printf("%d",ASCII_result);
	return 0;
}