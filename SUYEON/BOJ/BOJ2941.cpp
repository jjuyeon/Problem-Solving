#include <iostream>
#include <string>
using namespace std;

// ũ�ξ�Ƽ�� ���ĺ�
// �ܾ �־����� ��, �� ���� ũ�ξ�Ƽ�� ���ĺ����� �̷���� �ִ��� ����Ѵ�.
int main(void){
	// ù° �ٿ� �ִ� 100������ �ܾ �־�����. ���ĺ� �ҹ��ڿ� '-', '='�θ� �̷���� �ִ�.
	// ���� ���� �����ִ� ũ�ξ�Ƽ�� ���ĺ��� �־�����.
	char input[100];
	cin>>input;
	
	int count = 0;
	for(int i=0; input[i]!='\0'; i++){ // ��Ģ���� ũ�ξ�Ƽ�� ���ĺ� ã��
		if(input[i] == 'c'){
			if(input[i+1] == '=' || input[i+1] == '-'){
                i++;
            }
        }else if(input[i] == 'd'){
            if(input[i+1] == '-'){
                i++;
            }else if(input[i+1] == 'z' && input[i+2] == '='){
                i+=2;
            }
        }else if(input[i] == 'l'){
            if(input[i+1] == 'j'){
                i++;
            }
        }else if(input[i] == 'n'){
            if(input[i+1] == 'j'){
                i++;
            }
        }else if(input[i] == 's'){
            if(input[i+1] == '='){
                i++;
            }
        }else if(input[i] == 'z') {
            if (input[i + 1] == '=') {
                i++;
            }
        }
        count++;
	}

	cout<<count;
	return 0;
}