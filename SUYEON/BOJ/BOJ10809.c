#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <ctype.h>

// ���ĺ� �ҹ��ڷθ� �̷���� �ܾ� S�� �־�����. 
// ������ ���ĺ��� ���ؼ�, �ܾ ���ԵǾ� �ִ� ��쿡�� ó�� �����ϴ� ��ġ��, ���ԵǾ� ���� ���� ��쿡�� -1�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

int main(void){
	char input[100];
	int i=0, j=0;
	//result �迭
	char alphabet[26]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	int result[26];

	//result -1�� �ʱ�ȭ
	for(i=0; i<26; i++){
		result[i] = -1;
	}

	// �ܾ �Է� ����
	scanf("%s", input);
	//��� �ҹ��ڷ� ��ȯ	
	while(input[i]!='\0'){
	 input[i]=tolower(input[i]);
	 i++;
	}

	// �ܾ �ϳ��� �Է� �޾Ƽ� �ش�Ǵ� ���ĺ��� ��� �ε������� ó�� ��Ÿ������ �迭�� ����
	for(i=0; input[i]!='\0'; i++){
		for(j=0; j<26; j++){
			if(result[j] == -1 && input[i] == alphabet[j]){
				result[j] = i;
			}
		}
	}

	// ������ �䱸���׿� ���� ���
	for(i=0; i<26; i++){
		printf("%d ",result[i]);
	}

	return 0;
}