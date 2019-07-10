package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode {

    private int offset;
    String varName;
    @Override
    public void init(ArrayList<String> args) {
        offset = Integer.parseInt(args.get(0));
        varName = args.get(1);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.load(offset);
    }
}
