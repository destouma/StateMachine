package LoopStateMachine;

import StateMachine.IEvent;

public enum LoopEvent implements IEvent {
    EVT_START,
    EVT_CONNECT,
    EVT_RECEIVE,
    EVT_UPDATE,
    EVT_FINISH;
}
