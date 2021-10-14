package StateMachine;

import java.util.Set;

public class StateMachine implements IStateMachine{
    private String name;
    private IState currentState;
    private IState finalState;
    private IEvent currentEvent;

    private Set<ITransition> transitions;
    private Set<IState> states;

    StateMachine(String name){
        this.name = name;
        this.currentEvent = null;
        this.currentState = null;
        this.finalState = null;
        this.states = null;
        this.transitions = null;
    }

    public void setCurrentState(IState currentState) {
        this.currentState = currentState;
    }

    public void setFinalState(IState finalState) {
        this.finalState = finalState;
    }

    public void setCurrentEvent(IEvent currentEvent) {
        this.currentEvent = currentEvent;
    }

    public void setStates(Set<IState> states) {
        this.states = states;
    }

    public void setTransitions(Set<ITransition> transitions) {
        this.transitions = transitions;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public IState getCurrentState() {
        return null;
    }

    @Override
    public IState getInitialState() {
        return null;
    }

    @Override
    public Set<IState> getStates() {
        return null;
    }

    @Override
    public Set<ITransition> getTransitions() {
        return null;
    }

    @Override
    public IState fire(IEvent event) {
        return null;
    }

}
