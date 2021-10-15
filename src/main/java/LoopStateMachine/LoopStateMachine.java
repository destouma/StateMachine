package LoopStateMachine;

import StateMachine.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LoopStateMachine {
    private StateMachine stateMachine;
    private Set<ITransition> transitions;

    public LoopStateMachine(){
        createTransitions();
        createStateMachine();
    }

    public void start(){
        System.out.println("===> FIRE START EVENT");
        stateMachine.fire(LoopEvent.EVT_START);
    }

    public void connect(){
        System.out.println("===> FIRE CONNECT EVENT");
        stateMachine.fire(LoopEvent.EVT_CONNECT);
    }

    public void finish(){
        System.out.println("===> FIRE FINISH EVENT");
        stateMachine.fire(LoopEvent.EVT_FINISH);
    }

    private void createTransitions(){
        transitions = new HashSet<ITransition>();
        transitions.add(new TransitionBuilder("transition 01")
                .registerSourceState(LoopState.STATE_INIT)
                .registerDestinationState(LoopState.STATE_STARTED)
                .registerEvent(LoopEvent.EVT_START)
                .registerActionHandler(new IActionHandler() {
                    @Override
                    public void executeAction(IEvent e) {
                        System.out.println("transition 01 INIT ==> STARTED");
                    }
                })
                .build());
        transitions.add(new TransitionBuilder("transition 02")
                .registerSourceState(LoopState.STATE_STARTED)
                .registerDestinationState(LoopState.STATE_CONNECTED)
                .registerEvent(LoopEvent.EVT_CONNECT)
                .registerActionHandler(new IActionHandler() {
                    @Override
                    public void executeAction(IEvent e) {
                        System.out.println("transition 02 STARTED ==> CONNECTED");
                    }
                })
                .build());
        transitions.add(new TransitionBuilder("transition 03")
                .registerSourceState(LoopState.STATE_CONNECTED)
                .registerDestinationState(LoopState.STATE_FINISHED)
                .registerEvent(LoopEvent.EVT_FINISH)
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
                .registerInitialState(LoopState.STATE_INIT)
                .registerFinalState(LoopState.STATE_FINISHED)
                .registerTransitions(transitions)
                .build();
    }

}
