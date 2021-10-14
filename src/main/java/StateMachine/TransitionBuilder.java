package StateMachine;

public class TransitionBuilder {
    private final Transition transition;

    public TransitionBuilder(String name) {
        transition = new Transition(name);
    }

    public TransitionBuilder registerSourceState(IState sourceState){
        transition.setSourceState(sourceState);
        return this;
    }

    public TransitionBuilder registerDestinationState(IState destinationState){
        transition.setDestinationState(destinationState);
        return this;
    }

    public TransitionBuilder registerEvent(IEvent event){
        transition.setEvent(event);
        return this;
    }

    public TransitionBuilder registerActionHandler(IActionHandler actionHandler){
        transition.setActionHandler(actionHandler);
        return this;
    }

    public ITransition build(){
        return transition;
    }
}
