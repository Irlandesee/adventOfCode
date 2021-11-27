#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void readinput(FILE *fp);

int linelength(char *s);

/**
char[] getLine(FILE *fp);
**/

int main(int argc, char *argv[]){
	char fileName[100] = "/Users/mattiamac/Documents/Github/adventOfCode/c/2020/day6/input.txt";
	printf("%s\n", fileName);
	FILE *fp;
	if((fp = fopen(fileName, "r")) == NULL){
		printf("can't open %s\n", fileName);
		exit(1);
	}
	else{
		readinput(fp);
		fclose(fp);
	}
	return 0;
}

void readinput(FILE *fp){
	char c;
	int count = 0;
	while((c = getc(fp)) != EOF){
		if(c == '\n'){
			printf("%c\n", c);

		}
		else{
			printf("%c", c);
		}
	}
}

int linelength(char *s){
	int n; 
	for(n = 0; *s != '\0'; n++)
		n++;
	return n;
}

/**
char[] getLine(FILE *fp){

}
**/