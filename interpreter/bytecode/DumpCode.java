package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    Boolean dumpState;
    String dumpArgs;
    @Override
    public void init(ArrayList<String> args) {
        dumpArgs = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        if (dumpArgs.equals("ON")){
            virtualMachine.setDumpCode(true);
        }
    }
}
