package StateMachine;

import java.util.Set;

public class StateMachine implements IStateMachine{
    private String name;
    private IState initialState;
    private IState currentState;
    private IState finalState;
    private IEvent currentEvent;

    private Set<ITransition> transitions;
    private Set<IState> states;

    StateMachine(String name){
        this.name = name;
        this.currentEvent = null;
        this.initialState = null;
        this.currentState = null;
        this.finalState = null;
        this.states = null;
        this.transitions = null;
    }

    public void setInitialState(IState initialState) {
        this.currentState = initialState;
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
        return this.name;
    }

    @Override
    public IState getCurrentState() {
        return this.currentState;
    }

    @Override
    public IState getInitialState() {
        return this.initialState;
    }

    @Override
    public IState getFinalState() {
        return this.finalState;
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
