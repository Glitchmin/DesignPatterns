#include "States.h"
#include <iostream>

void StateStart::handleInput(char input, StateMachine& stateMachine)
{
	if (input == 'a') {
		stateMachine.setCurrentState(make_shared<StateA>());
		return;
	}
	if (input == 'b') {
		stateMachine.setCurrentState(make_shared<StateC>());
		return;
	}
	stateMachine.setCurrentState(make_shared<StateError>());
}

void StateA::handleInput(char input, StateMachine& stateMachine)
{
	if (input == 'b') {
		stateMachine.setCurrentState(make_shared<StateB>());
		return;
	}
	if (input == 'a') {
		return;
	}
	stateMachine.setCurrentState(make_shared<StateError>());
}

bool StateA::leadsToFinish()
{
	return true;
}

void StateB::handleInput(char input, StateMachine& stateMachine)
{
	if (input == 'a') {
		stateMachine.setCurrentState(make_shared<StateFinish>());
		return;
	}
	if (input == 'b') {
		return;
	}
	stateMachine.setCurrentState(make_shared<StateError>());
}

bool StateB::leadsToFinish()
{
	return true;
}

void StateC::handleInput(char input, StateMachine& stateMachine)
{
	if (input == 'c') {
		stateMachine.setCurrentState(make_shared<StateB>());
		return;
	}
	if (input == 'a') {
		return;
	}
	stateMachine.setCurrentState(make_shared<StateError>());
}

bool StateC::leadsToFinish()
{
	return true;
}

void StateFinish::handleInput(char input, StateMachine& stateMachine)
{
}

bool StateFinish::isFinish()
{
	return true;
}

bool AbstractState::isFinish()
{
	return false;
}

bool AbstractState::leadsToFinish()
{
	return false;
}

bool AbstractState::isError()
{
	return false;
}

void StateError::handleInput(char input, StateMachine& stateMachine)
{
}

bool StateError::isError()
{
	return true;
}
