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
    private Set<IEvent> events;

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
        this.initialState = initialState;
        this.currentState = initialState;

    }

    public void setFinalState(IState finalState) {
        this.finalState = finalState;
    }

    public void setStates(Set<IState> states) {
        this.states = states;
    }

    public void setTransitions(Set<ITransition> transitions) {
        this.transitions = transitions;
    }

    public void setEvents(Set<IEvent> events) {
        this.events = events;
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
    public IState fire(IEvent event) {
        if(event == null){
            return null;
        }else{
            for (ITransition transition : transitions) {
                if (currentState.equals(transition.getSourceState()) &&
                        transition.getEvent() == event) {
                    if(transition.getActionHandler() !=null){
                        transition.getActionHandler().executeAction(event);
                    }
                    currentState = transition.getDestinationState();
                    break;
                }
            }
            return currentState;
        }
    }

}
