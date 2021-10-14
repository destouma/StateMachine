package StateMachine;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class StateMachineRunningTest {
    enum TestState implements IState {
        TEST_STATE_1,
        TEST_STATE_2,
        TEST_STATE_3
    }
    enum TestEvent implements IEvent {
        TEST_EVENT_1,
        TEST_EVENT_2,
        TEST_EVENT_3
    }
    Set<IState> testStates = new HashSet<>(Arrays.asList(
            TestState.TEST_STATE_1,
            TestState.TEST_STATE_2,
            TestState.TEST_STATE_3));

    Set<IEvent> testEvents = new HashSet<>(Arrays.asList(
            TestEvent.TEST_EVENT_1,
            TestEvent.TEST_EVENT_2,
            TestEvent.TEST_EVENT_3));

    static Set<ITransition> testTransitions;

    static StateMachine stateMachine;

    @Test
    public void fireNullEvent() {
        Set<ITransition> testTransitions = new HashSet<ITransition>();
        testTransitions.add(new TransitionBuilder("test01")
                .registerSourceState(TestState.TEST_STATE_1)
                .registerDestinationState(TestState.TEST_STATE_2)
                .registerEvent(TestEvent.TEST_EVENT_1)
                .registerActionHandler(null)
                .build());
        testTransitions.add(new TransitionBuilder("test02")
                .registerSourceState(TestState.TEST_STATE_2)
                .registerDestinationState(TestState.TEST_STATE_3)
                .registerEvent(TestEvent.TEST_EVENT_2)
                .registerActionHandler(null)
                .build());

        StateMachine stateMachine = new StateMachineBuilder("test")
                .registerInitialState(TestState.TEST_STATE_1)
                .registerFinalState(TestState.TEST_STATE_3)
                .registerTransitions(testTransitions)
                .registerEvents(testEvents)
                .registerSates(testStates)
                .build();

        assert(stateMachine.fire(null) == null);
    }

    @Test
    public void firefirstEvent() {
        Set<ITransition> testTransitions = new HashSet<ITransition>();
        testTransitions.add(new TransitionBuilder("test01")
                .registerSourceState(TestState.TEST_STATE_1)
                .registerDestinationState(TestState.TEST_STATE_2)
                .registerEvent(TestEvent.TEST_EVENT_1)
                .registerActionHandler(null)
                .build());
        testTransitions.add(new TransitionBuilder("test02")
                .registerSourceState(TestState.TEST_STATE_2)
                .registerDestinationState(TestState.TEST_STATE_3)
                .registerEvent(TestEvent.TEST_EVENT_2)
                .registerActionHandler(null)
                .build());
        StateMachine stateMachine = new StateMachineBuilder("test")
                .registerInitialState(TestState.TEST_STATE_1)
                .registerFinalState(TestState.TEST_STATE_3)
                .registerTransitions(testTransitions)
                .registerEvents(testEvents)
                .registerSates(testStates)
                .build();

        assert(stateMachine.fire(TestEvent.TEST_EVENT_1) == TestState.TEST_STATE_2);
    }
}