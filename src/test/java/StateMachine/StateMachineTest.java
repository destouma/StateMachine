package StateMachine;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class StateMachineTest {
    enum TestState implements IState {
        TEST_STATE_1,
        TEST_STATE_2,
        TEST_STATE_3
    }

    Set<IState> testStates = new HashSet<>(Arrays.asList(
            TestState.TEST_STATE_1,
            TestState.TEST_STATE_2,
            TestState.TEST_STATE_3));

    @Test
    public void nameIsNull() {
        StateMachine m = new StateMachine(null);
        assert(m.getName()==null);
    }

    @Test
    public void nameIsNotNull() {
        StateMachine m = new StateMachine("test");
        assert(m.getName().contains("test"));
    }

    @Test
    public void initialStateIsNull() {
        StateMachine m = new StateMachine("test");
        m.setInitialState(null);
        assert(m.getInitialState()==null);
    }

    @Test
    public void initialStateNotNull() {
        StateMachine m = new StateMachine("test");
        m.setInitialState(TestState.TEST_STATE_1);
        assert(m.getInitialState()!=null);
    }

    @Test
    public void initialStateEqualValue() {
        StateMachine m = new StateMachine("test");
        m.setInitialState(TestState.TEST_STATE_1);
        assert(m.getInitialState()==TestState.TEST_STATE_1);
    }

    @Test
    public void finalStateIsNull() {
        StateMachine m = new StateMachine("test");
        m.setFinalState(null);
        assert(m.getFinalState()==null);
    }

    @Test
    public void finalStateNotNull() {
        StateMachine m = new StateMachine("test");
        m.setFinalState(TestState.TEST_STATE_1);
        assert(m.getFinalState()!=null);
    }

    @Test
    public void finalStateEqualValue() {
        StateMachine m = new StateMachine("test");
        m.setFinalState(TestState.TEST_STATE_1);
        assert(m.getFinalState()==TestState.TEST_STATE_1);
    }


}