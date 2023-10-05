package StateMachine;

import java.util.HashMap;
import java.util.Objects;

public class Transitions {
    HashMap<Integer, ITransition> transitions;

    public Transitions(){
        transitions = new HashMap<Integer, ITransition>();
    }

    public void add(ITransition transition){
        transitions.put(
                Objects.hash(
                    transition.getSourceState(),
                    transition.getEvent()
                ),
                transition
        );
    }

    public boolean contains(IState state, IEvent event) {
       return transitions.containsKey(Objects.hash(state,event));
    }

    public ITransition get(IState state, IEvent event){
        return transitions.get(Objects.hash(state,event));
    }
}
