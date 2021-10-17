package LoopStateMachine;

import StateMachine.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LoopStateMachine {
    private IStateMachine stateMachine;

    public LoopStateMachine(){
        this.stateMachine = createStateMachine(createTransitions());
    }

    public void start(){
        System.out.println("===> FIRE START EVENT");
        stateMachine.fire(LoopEvent.EVT_START);
    }

    public void connect(){
        System.out.println("===> FIRE CONNECT EVENT");
        stateMachine.fire(LoopEvent.EVT_CONNECT);
    }

    public void receive(){
        System.out.println("===> FIRE RECEIVE EVENT");
        stateMachine.fire(LoopEvent.EVT_RECEIVE);
    }

    public void update(){
        System.out.println("===> FIRE UPDATE EVENT");
        stateMachine.fire(LoopEvent.EVT_UPDATE);
    }

    public void finish(){
        System.out.println("===> FIRE FINISH EVENT");
        stateMachine.fire(LoopEvent.EVT_FINISH);
    }

    private Set<ITransition> createTransitions(){
        Set<ITransition> transitions = new HashSet<>();
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

        // option one: finish once connected
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

        // option two: loop on receive and update
        transitions.add(new TransitionBuilder("transition 04")
                .registerSourceState(LoopState.STATE_CONNECTED)
                .registerDestinationState(LoopState.STATE_RECEIVED)
                .registerEvent(LoopEvent.EVT_RECEIVE)
                .registerActionHandler(new IActionHandler() {
                    @Override
                    public void executeAction(IEvent e) {
                        System.out.println("transition 04 CONNECTED ==> RECEIVED");
                    }
                })
                .build());

        transitions.add(new TransitionBuilder("transition 05")
                .registerSourceState(LoopState.STATE_RECEIVED)
                .registerDestinationState(LoopState.STATE_UPDATED)
                .registerEvent(LoopEvent.EVT_UPDATE)
                .registerActionHandler(new IActionHandler() {
                    @Override
                    public void executeAction(IEvent e) {
                        System.out.println("transition 05 RECEIVED ==> UPDATED");
                    }
                })
                .build());

        transitions.add(new TransitionBuilder("transition 06")
                .registerSourceState(LoopState.STATE_UPDATED)
                .registerDestinationState(LoopState.STATE_FINISHED)
                .registerEvent(LoopEvent.EVT_FINISH)
                .registerActionHandler(new IActionHandler() {
                    @Override
                    public void executeAction(IEvent e) {
                        System.out.println("transition 06 UPDATED ==> FINISHED");
                    }
                })
                .build());

        transitions.add(new TransitionBuilder("transition 07")
                .registerSourceState(LoopState.STATE_UPDATED)
                .registerDestinationState(LoopState.STATE_RECEIVED)
                .registerEvent(LoopEvent.EVT_RECEIVE)
                .registerActionHandler(new IActionHandler() {
                    @Override
                    public void executeAction(IEvent e) {
                        System.out.println("transition 07 UPDATED ==> RECEIVED");
                    }
                })
                .build());
        return transitions;
    }

    private IStateMachine createStateMachine(Set<ITransition> transitions){
        return new StateMachineBuilder("test")
                .registerInitialState(LoopState.STATE_INIT)
                .registerFinalState(LoopState.STATE_FINISHED)
                .registerTransitions(transitions)
                .build();
    }

}
