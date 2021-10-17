package ExampleStateMachine;

import StateMachine.IStateMachine;
import StateMachine.ITransition;
import StateMachine.IEvent;
import StateMachine.StateMachineBuilder;
import StateMachine.TransitionBuilder;
import StateMachine.IActionHandler;

import java.util.HashSet;
import java.util.Set;

public class ExampleStateMachine {
    private IStateMachine stateMachine;

    public ExampleStateMachine(){
        this.stateMachine = createStateMachine(createTransitions());
    }

    public void start(){
        System.out.println("===> FIRE START EVENT");
        this.stateMachine.fire(ExampleEvent.EVT_START);
    }

    public void connect(){
        System.out.println("===> FIRE CONNECT EVENT");
        this.stateMachine.fire(ExampleEvent.EVT_CONNECT);
    }

    public void finish(){
        System.out.println("===> FIRE FINISH EVENT");
        this.stateMachine.fire(ExampleEvent.EVT_FINISH);
    }

    private Set<ITransition> createTransitions(){
        Set<ITransition> transitions = new HashSet<>();
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
        return transitions;
    }

    private IStateMachine createStateMachine(Set<ITransition> transitions){
        return  new StateMachineBuilder("test")
                .registerInitialState(ExampleState.STATE_INIT)
                .registerFinalState(ExampleState.STATE_FINISHED)
                .registerTransitions(transitions)
                .build();
    }
}
