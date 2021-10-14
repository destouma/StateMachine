package StateMachine;

import java.util.Set;

public class StateMachineBuilder {
    private final StateMachine stateMachine;

    StateMachineBuilder(String name){
        this.stateMachine = new StateMachine(name);
    }

    public StateMachineBuilder registerCurrentEvent(IEvent event){
        this.stateMachine.setCurrentEvent(event);
        return this;
    }

    public StateMachineBuilder registerCurrentState(IState state){
        this.stateMachine.setCurrentState(state);
        return this;
    }

    public StateMachineBuilder registerFinalState(IState state){
        this.stateMachine.setFinalState(state);
        return this;
    }

    public StateMachineBuilder registerSates(Set<IState> states){
        this.stateMachine.setStates(states);
        return this;
    }

    public StateMachineBuilder registerTransitions(Set<ITransition> transitions){
        this.stateMachine.setTransitions(transitions);
        return this;
    }

    public StateMachine build(){
        return this.stateMachine;
    }
}
