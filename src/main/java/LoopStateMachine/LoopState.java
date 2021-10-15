package LoopStateMachine;

import StateMachine.IState;

public enum LoopState implements IState {
    STATE_INIT,
    STATE_STARTED,
    STATE_CONNECTED,
    STATE_RECEIVED,
    STATE_UPDATED,
    STATE_FINISHED;
}
