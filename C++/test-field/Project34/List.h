#include <iostream>
#include <algorithm>
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
	void sorting(string);
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

void List::sorting(string s) {
	Node *here = head;
	Node *nextnext = new Node();
	Node *prev = new Node();
	int flag = 0;

	while (here->next != NULL && flag != 7)
	{
 		if (s == "SID") {
			if (here->prev == NULL && here->SID < here->next->SID) {
				here->next = here->next->next;
				here->prev = here->next->prev;
				here->prev->next = here;
				here->next->prev = here;

				here->prev->prev = NULL;
				this->head = here->prev;
			}
			else if (here->next->next == NULL) {
				if (here->SID < here->next->SID) {
					here->prev->next = here->next;
					here->prev->next->next = here;
					here->prev->next->prev = here->prev;
					here->prev = here->prev->next;

					this->tail = here;
					here->next = NULL;
				}
				else {
					here->prev->next;
					flag++;
				}
				here->next->next - NULL;
				here = this->head;	
			}
				
			else if (here->SID < here->next->SID) {
				nextnext = here->next->next;
				prev = here->prev;

				prev->next = here->next;
				here->next->next = here;
				here->next = nextnext;
				nextnext->prev = here;
				here->prev = prev->next;
				here->prev->prev = prev;
			}
			else
			{
				here = here->next;
			}
		}
		else if (s == "GPA")
		{
			for (int i = 0; i < 7; i++) {
				do {
					if (here->GPA < here->next->GPA || here->next != NULL) {
						if (here->prev != NULL)
						{
							here->prev->next = here->next;
						}
						here->next = here->next->next;
						here->next->prev->next = here;
					}
					here = here->next;
				} while (here != NULL);
				here = head;
			}
			
		}
	}
}