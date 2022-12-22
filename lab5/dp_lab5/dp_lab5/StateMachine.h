#pragma once
#include <map>
#include <memory>
#include "States.h"
#include <string>
using std::string;
using std::shared_ptr;

class AbstractState;

class StateMachine {
public:
	void setCurrentState(shared_ptr<AbstractState> newState);
	void handleInput(string word);
private:
	shared_ptr<AbstractState> currentState;
};