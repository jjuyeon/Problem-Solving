#include <iostream>
#include <string>
#include <algorithm>

// ����� ���ڸ� �дµ� ������ �ִ�. ����̴� �� �ڸ� ���� �� ���� ĥ�ǿ� ���־���. �� ������ ũ�Ⱑ ū ���� ���غ���� �ߴ�.
// ����� ���� �ٸ� ����� �ٸ��� �Ųٷ� �д´�. �� ���� �־����� ��, ����� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

using namespace std;

int main(void){
	// �ѹ��� �� �ڸ� ���� 2���� �޾ƿ´�.
	char input[8];
	cin.getline(input,8,'\n');

	string compare1="";
	string compare2="";

	// �ѹ��� ���� ���� 2���� ������ ���ڷ� �Ľ��Ѵ�.
	bool next = false;
	for(int i=0; input[i]!='\0'; i++){
		if(input[i] == ' '){
			next = true;
			continue;
		}

		if(next){
			compare2 += input[i];
		}else {
			compare1 += input[i];
		}
	}
	
	// �Ľ��� ���� 2���� reverse�Ѵ�.
	reverse(compare1.begin(), compare1.end());
	reverse(compare2.begin(), compare2.end());

	// reverse�� ���� 2���� ���Ͽ� ����Ѵ�.
	if(compare1.compare(compare2)<0){
		cout<<compare2<<endl;
	}else{
		cout<<compare1<<endl;
	}
	return 0;
}