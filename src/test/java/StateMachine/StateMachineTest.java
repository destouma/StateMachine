package StateMachine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StateMachineTest {
    enum TestState implements IState {
        TEST_STATE_1,
        TEST_STATE_2,
        TEST_STATE_3;
    }
    enum TestEvent implements IEvent {
        TEST_EVENT_1,
        TEST_EVENT_2,
        TEST_EVENT_3;
    }
    Set<IState> testStates = new HashSet<IState>(Arrays.asList(
            TestState.TEST_STATE_1,
            TestState.TEST_STATE_2,
            TestState.TEST_STATE_3));

    Set<IEvent> testEvents = new HashSet<IEvent>(Arrays.asList(
            TestEvent.TEST_EVENT_1,
            TestEvent.TEST_EVENT_2,
            TestEvent.TEST_EVENT_3));


}