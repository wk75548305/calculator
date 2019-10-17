#include <iostream>
#include <string>
using namespace std;


class Node {
public:
	int SID;
	string name;
	int GPA;
	Node *next;
	Node *prev;
	Node(int, string, int);
	Node();
};


Node::Node(int a, string b, int c) {
	this->SID = a;
	this->name = b;
	this->GPA = c;
}

Node::Node() {
	this->SID = 0;
	this->name = "LOL";
	this->GPA = 0;
}