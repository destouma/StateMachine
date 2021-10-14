package ExampleStateMachine;

import StateMachine.IEvent;

public enum ExampleEvent implements IEvent {
    EVT_START,
    EVT_CONNECT,
    EVT_FINISH;
}
