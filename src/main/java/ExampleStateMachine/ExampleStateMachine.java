package ExampleStateMachine;

import StateMachine.StateMachine;
import StateMachine.ITransition;
import StateMachine.IState;
import StateMachine.IEvent;
import StateMachine.StateMachineBuilder;
import StateMachine.TransitionBuilder;
import StateMachine.IActionHandler;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExampleStateMachine {
    private StateMachine stateMachine;
    private Set<ITransition> transitions;

    private Set<IState> states = new HashSet<>(Arrays.asList(
            ExampleState.STATE_INIT,
            ExampleState.STATE_STARTED,
            ExampleState.STATE_CONNECTED,
            ExampleState.STATE_FINISHED));

    private Set<IEvent> events = new HashSet<>(Arrays.asList(
            ExampleEvent.EVT_START,
            ExampleEvent.EVT_CONNECT,
            ExampleEvent.EVT_FINISH));

    public ExampleStateMachine(){
        createTransitions();
        createStateMachine();
    }

    public void start(){
        System.out.println("===> FIRE START EVENT");
        stateMachine.fire(ExampleEvent.EVT_START);
    }

    public void connect(){
        System.out.println("===> FIRE CONNECT EVENT");
        stateMachine.fire(ExampleEvent.EVT_CONNECT);
    }

    public void finish(){
        System.out.println("===> FIRE FINISH EVENT");
        stateMachine.fire(ExampleEvent.EVT_FINISH);
    }

    private void createTransitions(){
        transitions = new HashSet<ITransition>();
        transitions.add(new TransitionBuilder("transition 01")
                .registerSourceState(ExampleState.STATE_INIT)
                .registerDestinationState(ExampleState.STATE_STARTED)
                .registerEvent(ExampleEvent.EVT_START)
                .registerActionHandler(new IActionHandler() {
                    @Override
                    public void executeAction(IEvent e) {
                        System.out.println("transition 01 INIT ==> STARTED");
                    }
                })
                .build());
        transitions.add(new TransitionBuilder("transition 02")
                .registerSourceState(ExampleState.STATE_STARTED)
                .registerDestinationState(ExampleState.STATE_CONNECTED)
                .registerEvent(ExampleEvent.EVT_CONNECT)
                .registerActionHandler(new IActionHandler() {
                    @Override
                    public void executeAction(IEvent e) {
                        System.out.println("transition 02 STARTED ==> CONNECTED");
                    }
                })
                .build());
        transitions.add(new TransitionBuilder("transition 03")
                .registerSourceState(ExampleState.STATE_CONNECTED)
                .registerDestinationState(ExampleState.STATE_FINISHED)
                .registerEvent(ExampleEvent.EVT_FINISH)
                .registerActionHandler(new IActionHandler() {
                    @Override
                    public void executeAction(IEvent e) {
                        System.out.println("transition 03 CONNECTED ==> FINISHED");
                    }
                })
                .build());
    }

    private void createStateMachine(){
        stateMachine = new StateMachineBuilder("test")
                .registerInitialState(ExampleState.STATE_INIT)
                .registerFinalState(ExampleState.STATE_FINISHED)
                .registerTransitions(transitions)
                .registerEvents(events)
                .registerSates(states)
                .build();
    }

}
