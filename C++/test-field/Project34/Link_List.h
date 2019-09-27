#include <iostream>;
using namespace std;

class List{
private:
	Node *head = nullptr;
	Node *index[100] = { 0 };
public:
	static int length;
	void printcontent(int);
	void addnode(int,int);
	void delnode(int);
	List();
};

int List::length = 0;

void List::printcontent(int position) {
	Node *dest = new Node;
	dest = index[position];
	cout << dest->data1 << " " << dest->data2 << " " << dest->data3 << endl;
}



class Node {
public:
	int data1;
	int data2;
	int data3;
	Node(int, int, int);
	Node();
};