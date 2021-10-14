package StateMachine;

public interface ITransition {
    String getName();

    IState getSourceState();

    IState getDestinationState();

    IEvent getEvent();

    IActionHandler getActionHandler();
}
