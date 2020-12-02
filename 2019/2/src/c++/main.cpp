#import <iostream>
#include <sstream>
#include <fstream>
#include <vector>
#include <iterator>


using namespace std;

struct intcode{
	int opcode;
	int firstInputPosition, secondInputPosition;
	int outputPosition;
};

int main(){
	vector<string> tokens;
	string line;
	
	string intermediate;
	ifstream f ("input.txt");
	if(f.is_open()){
		getline(f, line);
		stringstream check1(line);
		while(getline(check1, intermediate, ','))
			tokens.push_back(intermediate);
		f.close();
	
	}
	else
		cout << "Unable to open file";
		
	for(int i = 0; i < tokens.size(); i++){
		cout << tokens[i] << '\n';
	}

	return 0;
}