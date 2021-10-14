package StateMachine;

import java.util.Set;

public interface IStateMachine {

    String getName();

    IState getCurrentState();

    IState getInitialState();

    Set<IState> getStates();

    Set<ITransition> getTransitions();

    IState fire(IEvent event);
}
