#include <iostream>
#include <cctype>

//  ���ڸ� �ϳ��� ���� ������ �ݼ� ���� �ִ� �� ���� �ð�������� ������ �Ѵ�. 
// �ٸ� ���ڸ� �������� ���̾��� ���� ��ġ�� ���ư��⸦ ��ٷ��� �Ѵ�. �� ĭ ���� �ִ� ���ڸ� �ɱ� ���ؼ� 1�ʾ� �� �ɸ���.
//  �ҸӴϰ� �ܿ� �ܾ �־����� ��, �� ��ȭ�� �ɱ� ���ؼ� �ʿ��� �ð��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
int main(void){
	// ù° �ٿ� ���ĺ� �빮�ڷ� �̷���� �ܾ �־�����. �ܾ�� 2����~15���ڷ� �̷���� �ִ�.
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
	} //dial number�� ���Ͽ� ���Ѵ�.(dial number�� 2���� ���� + �߰��ð� 1��)
	
	std::cout<< time;

	return 0;
}