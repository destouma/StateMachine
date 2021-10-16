import ExampleStateMachine.ExampleStateMachine;
import LoopStateMachine.LoopStateMachine;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello State Machine");

        // Example State Machine
        System.out.println("===> Simple state machine");
        ExampleStateMachine stateMachine = new ExampleStateMachine();
        stateMachine.start();
        Thread.sleep(5000);
        stateMachine.connect();
        Thread.sleep(5000);
        stateMachine.finish();

        // Loop State Machine
        System.out.println("===> Loop state machine");
        LoopStateMachine loopMachine = new LoopStateMachine();
        loopMachine.start();
        Thread.sleep(5000);

        loopMachine.connect();
        Thread.sleep(5000);

        for(int i = 0; i < 2;i++) {
            loopMachine.receive();
            Thread.sleep(5000);

            loopMachine.update();
            Thread.sleep(5000);
        }

        loopMachine.finish();
    }
}
