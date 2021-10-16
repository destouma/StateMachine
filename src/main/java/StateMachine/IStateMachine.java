package StateMachine;

import java.util.Set;

public interface IStateMachine {

    IState init();

    String getName();

    IState getCurrentState();

    IState getInitialState();

    IState getFinalState();

    IState fire(IEvent event);
}
