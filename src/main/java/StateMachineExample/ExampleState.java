package StateMachineExample;

import StateMachine.IState;

public enum ExampleState implements IState {
    STATE_INIT,
    STATE_STARTED,
    STATE_CONNECTED,
    STATE_FINISHED;
}
