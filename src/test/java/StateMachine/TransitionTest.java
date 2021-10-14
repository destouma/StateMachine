package StateMachine;

import org.junit.jupiter.api.Test;
enum ExampleState implements IState {
    TEST_STATE_1,
    TEST_STATE_2,
    TEST_STATE_3;
}

public class TransitionTest {
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
        t.setSourceState(ExampleState.TEST_STATE_1);
        assert(t.getSourceState()!=null);
    }

    @Test
    public void sourceStateEqualValue() {
        Transition t = new Transition("test");
        t.setSourceState(ExampleState.TEST_STATE_1);
        assert(t.getSourceState()==ExampleState.TEST_STATE_1);
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
        t.setDestinationState(ExampleState.TEST_STATE_1);
        assert(t.getDestinationState()!=null);
    }

    @Test
    public void destinationEqualValue() {
        Transition t = new Transition("test");
        t.setDestinationState(ExampleState.TEST_STATE_1);
        assert(t.getDestinationState()==ExampleState.TEST_STATE_1);
    }

}