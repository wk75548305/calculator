#include <iostream>
#include "List.h"
using namespace std;

int main();



int main() {
	List *list = new List();
	Node *array[7];
	string d[7] = { "ab","bc","cd","de","ef","fg","gh"};
	string x;

	for (int i = 0; i < 7; i++) {
		 array[i] = new Node(i, d[i], i);
		list->addnode(array[i]);
	}

	list->printallcontent();

	x = list->search(4);
	cout << x  << endl;

	system("pause");
	return 0;
}