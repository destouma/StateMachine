import ExampleStateMachine.ExampleStateMachine;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello State Machine");
        ExampleStateMachine stateMachine = new ExampleStateMachine();
        stateMachine.start();
        Thread.sleep(10000);
        stateMachine.connect();
        Thread.sleep(10000);
        stateMachine.finish();
    }
}
