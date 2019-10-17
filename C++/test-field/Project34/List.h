#include <iostream>
#include <string>
#include "Node.h"
using namespace std;


class List{
private:
	Node *head;
	Node *tail;
public:
	static int length;
	void printallcontent();
	void addnode(Node *node);
	void delnode(Node *node);
	string search(int);
	void sort(string);
	List();
};

int List::length = 0;

List::List() {
	head = NULL;
	tail = NULL;
	length = 0;
}

void List::printallcontent() {
	Node *here = head;
	while (here != NULL) {
		cout << here->SID << " " << here->name << " " << here->GPA << endl;
		here = here->next;
	}
}

void List::addnode(Node *node) {
	if (length == 0) {
		node->prev = NULL;
		head = node;
	}
	else
	{
		node->prev = tail;
		tail->next = node;
	}
	node->next = NULL;
	tail = node;
	length++;
}

void List::delnode(Node *node) {
	node->prev->next = node->next;
	node->next->prev = node->prev;
	length--;
}

string List::search(int target) {
	Node *here = head;
	while (here->SID != target) {
		if (here->next == NULL) return "none";
		here = here->next;
	}
	return here->name;
}

void List::sort(string s) {
	Node *here = head;
	if (s == "SID") {
		while (here != NULL) {
			if (here->SID < here->next->SID) {
				Node *temp = new Node();
				temp = here->next;
				here->next = here;
				here->next = temp;
			}
		}
	}
}