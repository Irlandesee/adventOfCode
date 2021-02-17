#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <fstream>

using namespace std;

#define tree = '#';
#define openSpace = '.';

/*
*	Checks if the passed char is equal or not
*	to #
*/
void checkChar(const char& c){
	
}

vector<string> readFile(const string& filename){
	string line = "";
	vector<string> ris;
	ifstream f (filename);
	if(f.is_open()){
		while(getline(f, line)){
			ris.push_back(line);
		}
		cout << "\nDone Reading from: " << filename << "\n";
	}

	return ris;
}

void printSlope(const vector<string ß>& slope){
	for(auto& line : slope)
		cout << line << "\n";
}


int main(int argc, char** argv){
	if(argc < 2)
		cout << "Inserisci input file!";
	else{
		string filename = argv[1];

		vector<string> slope = readFile(filename);
		printSlope(slope);

	}
}