#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

// ���ڿ� S�� �Է¹��� �Ŀ�, �� ���ڸ� R�� �ݺ��� �� ���ڿ� P�� ���� �� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
int main(void){
	char input[1000];
	char* ptr;
	int R=0, i=0, j=0, k=0, size=0, count;
	char S[21]; //20���ڱ��� �� �� ����.
	
	// �� �׽�Ʈ ���̽��� �ݺ� Ƚ�� R(1 �� R �� 8), ���ڿ� S�� �������� ���еǾ� �־�����. 
	scanf("%d", &count);
	getchar(); // ���۸� �����.

	// �׽�Ʈ ���̽���ŭ �ݺ�
	for(k=0; k<count; k++){
	// S�� ���̴� ��� 1�̸�, 20���ڸ� ���� �ʴ´�. 
	// '%[^\0] -> ���͸� ������ ��� ���ڿ��� ���� �� �ֵ��� ��.
	scanf("%[^\n]",input);
	
	// �Ľ��Ͽ� �ش�Ǵ� ������ ���� �����Ѵ�.
	size=0; // size �ʱ�ȭ
	R = atoi(&input[0]);
	for(i=2; input[i]!='\0'; i++){
		S[size++] = input[i];
	}
	S[size]= '\0';	

	// ������ ���ǿ� �°� �ݺ��Ͽ� ����Ѵ�.
	for(i=0;S[i]!='\0';i++){
		for(j=0; j<R; j++){
			printf("%c", S[i]);
		}
	}

	printf("\n");
	getchar(); // ���۸� �����.
	}

	
	
	return 0;
}