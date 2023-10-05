package StateMachine;

import java.util.HashMap;
import java.util.Set;

public class StateMachineBuilder {
    private final StateMachine stateMachine;

    public StateMachineBuilder(String name){
        this.stateMachine = new StateMachine(name);
    }

    public StateMachineBuilder registerInitialState(IState state){
        this.stateMachine.setInitialState(state);
        return this;
    }

    public StateMachineBuilder registerFinalState(IState state){
        this.stateMachine.setFinalState(state);
        return this;
    }

    public StateMachineBuilder registerTransitions( Transitions transitions){
        this.stateMachine.setTransitions(transitions);
        return this;
    }

    public StateMachine build(){
        return this.stateMachine;
    }
}
