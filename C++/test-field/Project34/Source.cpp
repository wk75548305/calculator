#include <iostream>
#include "List.h"
using namespace std;

int main();



int main() {
	List *list = new List();
	Node *array[7];
	string d[7] = { "aasdz","badd","bcgsdhd","defk","feav","fdsfg","ffddsf"};
	string x;

	//INTRODUCTION TO THIS PROGRAM
	//
	//



	for (int i = 0; i < 7; i++) {
		 array[i] = new Node(i, d[i], i);
		list->addnode(array[i]);
	}

	list->printallcontent();

	cin >> x;

	list->sorting(x);

	list->printallcontent();

	system("pause");
	return 0;
}