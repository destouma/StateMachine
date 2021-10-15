package StateMachine;

import java.util.Set;

public interface IStateMachine {

    void init();

    String getName();

    IState getCurrentState();

    IState getInitialState();

    IState getFinalState();

    IState fire(IEvent event);
}
