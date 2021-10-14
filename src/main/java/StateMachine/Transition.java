package StateMachine;

public class Transition implements ITransition {
    private String name;
    private IState sourceState;
    private IState destinationState;
    private IEvent event;
    private IActionHandler actionHandler;

    Transition(String name){
        this.name = name;
    }

    public void setSourceState(IState sourceState) {
        this.sourceState = sourceState;
    }

    public void setDestinationState(IState destinationState) {
        this.destinationState = destinationState;
    }

    public void setEvent(IEvent event) {
        this.event = event;
    }

    public void setActionHandler(IActionHandler actionHandler) {
        this.actionHandler = actionHandler;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public IState getSourceState() {
        return this.sourceState;
    }

    @Override
    public IState getDestinationState() {
        return this.destinationState;
    }

    @Override
    public IEvent getEvent() {
        return null;
    }

    @Override
    public IActionHandler getActionHandler() {
        return null;
    }
}
