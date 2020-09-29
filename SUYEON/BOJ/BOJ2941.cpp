#include <iostream>
#include <string>
using namespace std;

// 크로아티아 알파벳
// 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
int main(void){
	// 첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.
	// 문제 설명에 나와있는 크로아티아 알파벳만 주어진다.
	char input[100];
	cin>>input;
	
	int count = 0;
	for(int i=0; input[i]!='\0'; i++){ // 규칙별로 크로아티아 알파벳 찾기
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