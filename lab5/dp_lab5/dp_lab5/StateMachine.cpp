#include "StateMachine.h"
#include <iostream>

void StateMachine::setCurrentState(shared_ptr<AbstractState> newState)
{
	currentState = newState;
}

void StateMachine::handleInput(string word)
{
	currentState = make_shared<StateStart>();
	for (char c : word) {
		if (currentState->isFinish()) {
			std::cout << "the word does not belong to the language" << std::endl;
			return;
		}
		currentState->handleInput(c, *this);
		if (currentState->isError()) {
			std::cout << "the word does not belong to the language" << std::endl;
			return;
		}
	}
	if (currentState->leadsToFinish() || currentState->isFinish()) {
		std::cout << "the word belongs to the language" << std::endl;
	}
}
