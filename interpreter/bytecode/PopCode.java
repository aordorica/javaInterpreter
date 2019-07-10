package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {

    public int numPop;
    public void init(ArrayList<String> args) {
        numPop = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        for (int i = 0; i <= numPop; i++){
            virtualMachine.pop();
        }

    }
}
