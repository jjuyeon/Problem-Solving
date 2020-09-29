#include <iostream>
#include <cctype>

//  숫자를 하나를 누른 다음에 금속 핀이 있는 곳 까지 시계방향으로 돌려야 한다. 
// 다른 숫자를 누르려면 다이얼이 원래 위치로 돌아가기를 기다려야 한다. 한 칸 옆에 있는 숫자를 걸기 위해선 1초씩 더 걸린다.
//  할머니가 외운 단어가 주어졌을 때, 이 전화를 걸기 위해서 필요한 시간을 구하는 프로그램을 작성하시오.
int main(void){
	// 첫째 줄에 알파벳 대문자로 이루어진 단어가 주어진다. 단어는 2글자~15글자로 이루어져 있다.
	char input[16];
	std::cin>>input;

	int time = 0;
	for(int i=0; input[i]; i++){
		input[i]=toupper(input[i]);

		if (input[i] == '1'){
			time += 2;
		}
        else if (65 <= input[i] && input[i] <= 67){
            time += 3;
		}
        else if (68 <= input[i] && input[i] <= 70){
            time += 4;
		}
        else if (71 <= input[i] && input[i] <= 73){
            time += 5;
		}
        else if (74 <= input[i] && input[i] <= 76){
            time += 6;
		}
        else if (77 <= input[i] && input[i] <= 79){
            time += 7;
		}
        else if (80 <= input[i] && input[i] <= 83){
            time += 8;
		}
        else if (84 <= input[i] && input[i] <= 86){
            time += 9;
		}
        else if (87 <= input[i] && input[i] <= 91){
            time += 10;
		}
        else{
            time += 11;
		}
	} //dial number를 구하여 더한다.(dial number는 2부터 시작 + 추가시간 1초)
	
	std::cout<< time;

	return 0;
}