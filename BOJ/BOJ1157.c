#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <ctype.h>

typedef unsigned char Bool;
#define true 1
#define false 0

//���ĺ� ��ҹ��ڷ� �� �ܾ �־�����, �� �ܾ�� ���� ���� ���� ���ĺ��� �������� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�. ��, �빮�ڿ� �ҹ��ڸ� �������� �ʴ´�.
//ù° �ٿ� �� �ܾ�� ���� ���� ���� ���ĺ��� �빮�ڷ� ����Ѵ�. ��, ���� ���� ���� ���ĺ��� ���� �� �����ϴ� ��쿡�� ?�� ����Ѵ�.
int main(void){
	char input[1000000];
	int i=0, j=0;
	int maximum_index = 0;
	Bool check  = false;	
	//result �迭
	char alphabet[26]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	int result[26]={0};

	//�ܾ� �Է�
	scanf("%s", input);

	//��� �빮�ڷ� ��ȯ	
	while(input[i]!='\0'){
	 input[i]=toupper(input[i]);
	 i++;
	}

	//���ĺ� �󵵼� ����
	for(i=0; input[i]!='\0'; i++){
		for(j=0; j<26; j++){
			if(input[i] == 'A'+j){
				result[j]+=1;
			}
		}
	}

	//���� ���� ���� ���ĺ� Ȯ��(sorting)
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
	
	//���� ���� ���� ���ĺ��� ���� ���� ���
	if(result[25] == result[24]){
		printf("?");
	}
	//�ƴ� ���
	else{
		printf("%c",alphabet[25]);
	}

	return 0;
}