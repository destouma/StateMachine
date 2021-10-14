package StateMachine;

import java.util.Set;

public interface IStateMachine {

    IState getCurrentState();

    IState getInitialState();

    Set<IState> getStates();

    Set<ITransition> getTransitions();

    IState fire(IEvent event);

}
