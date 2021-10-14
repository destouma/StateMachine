package StateMachine;

import org.junit.jupiter.api.Test;

public class TransitionTest {
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

    @Test
    public void nameIsNull() {
        Transition t = new Transition(null);
        assert(t.getName()==null);
    }

    @Test
    public void nameIsNotNull() {
        Transition t = new Transition("test");
        assert(t.getName().contains("test"));
    }

    @Test
    public void sourceStateIsNull() {
        Transition t = new Transition("test");
        t.setSourceState(null);
        assert(t.getSourceState()==null);
    }

    @Test
    public void sourceStateNotNull() {
        Transition t = new Transition("test");
        t.setSourceState(TestState.TEST_STATE_1);
        assert(t.getSourceState()!=null);
    }

    @Test
    public void sourceStateEqualValue() {
        Transition t = new Transition("test");
        t.setSourceState(TestState.TEST_STATE_1);
        assert(t.getSourceState()==TestState.TEST_STATE_1);
    }

    @Test
    public void destinationStateIsNull() {
        Transition t = new Transition("test");
        t.setDestinationState(null);
        assert(t.getDestinationState()==null);
    }

    @Test
    public void destinationStateNotNull() {
        Transition t = new Transition("test");
        t.setDestinationState(TestState.TEST_STATE_1);
        assert(t.getDestinationState()!=null);
    }

    @Test
    public void destinationEqualValue() {
        Transition t = new Transition("test");
        t.setDestinationState(TestState.TEST_STATE_1);
        assert(t.getDestinationState()==TestState.TEST_STATE_1);
    }

    @Test
    public void eventIsNull() {
        Transition t = new Transition("test");
        t.setEvent(null);
        assert(t.getEvent()==null);
    }

    @Test
    public void eventNotNull() {
        Transition t = new Transition("test");
        t.setEvent(TestEvent.TEST_EVENT_1);
        assert(t.getEvent()!=null);
    }

    @Test
    public void eventEqualValue() {
        Transition t = new Transition("test");
        t.setEvent(TestEvent.TEST_EVENT_1);
        assert(t.getEvent()==TestEvent.TEST_EVENT_1);
    }

}