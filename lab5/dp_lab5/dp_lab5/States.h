#pragma once
#include "StateMachine.h"
using std::shared_ptr;
using std::make_shared;

class StateMachine;

class AbstractState {
public:
	virtual void handleInput(char input, StateMachine& stateMachine) = 0;
	virtual bool isFinish();
	virtual bool leadsToFinish();
	virtual bool isError();
};

class StateStart : public AbstractState {
public:
	virtual void handleInput(char input, StateMachine& stateMachine) override;
};

class StateA : public AbstractState {
public:
	virtual void handleInput(char input, StateMachine& stateMachine) override;
	virtual bool leadsToFinish();
};

class StateB : public AbstractState {
public:
	virtual void handleInput(char input, StateMachine& stateMachine) override;
	virtual bool leadsToFinish();
};

class StateC : public AbstractState {
public:
	virtual void handleInput(char input, StateMachine& stateMachine) override;
	virtual bool leadsToFinish();
};

class StateFinish : public AbstractState {
public:
	virtual void handleInput(char input, StateMachine& stateMachine) override;
	virtual bool isFinish();
};

class StateError : public AbstractState {
public:
	virtual void handleInput(char input, StateMachine& stateMachine) override;
	virtual bool isError();
};

