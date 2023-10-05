package StateMachine;

import java.util.Set;

public class StateMachine implements IStateMachine{
    private String name;
    private IState initialState;
    private IState currentState;
    private IState finalState;

//    private Set<ITransition> transitions;
    private Transitions transitions;

    StateMachine(String name){
        this.name = name;
        this.initialState = null;
        this.currentState = null;
        this.finalState = null;
        this.transitions = null;
    }

    public void setInitialState(IState initialState) {
        this.initialState = initialState;
        this.currentState = initialState;

    }

    public void setFinalState(IState finalState) {
        this.finalState = finalState;
    }

    public void setTransitions(Transitions transitions) {
        this.transitions = transitions;
    }

    @Override
    public IState init() {
        this.currentState = this.initialState;
        return this.currentState;
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
            ITransition tmpT = transitions.get(currentState,event);
            if(tmpT != null){
                if(tmpT.getActionHandler() != null){
                    tmpT.getActionHandler().executeAction(event);
                }
                currentState =tmpT.getDestinationState();
            }
            if(transitions.contains(currentState,event)){

            }
            return currentState;
        }
    }

}
