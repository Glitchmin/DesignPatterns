#include <iostream>
#include "StateMachine.h"

using namespace std;

int main()
{
	StateMachine stateMachine;
	string s;
	std::cin >> s;
	stateMachine.handleInput(s);
	return 0;
}
