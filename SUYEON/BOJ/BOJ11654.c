#define _CRT_SECURE_NO_WARNINGS //scanf() ������ �����ϱ� ���� ��� ����
#include <stdio.h>

//���ĺ� �ҹ���, �빮��, ���� 0-9�� �ϳ��� �־����� ��, �־��� ������ �ƽ�Ű �ڵ尪�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
int main(void){
	int ASCII_result = 0;
	char input;
	scanf("%c",&input);
	ASCII_result = (int)input;
	printf("%d",ASCII_result);
	return 0;
}