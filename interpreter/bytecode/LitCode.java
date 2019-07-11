package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {
    private int value;
    String varName;

    @Override
    public void init(ArrayList<String> args) {
        value = Integer.parseInt(args.get(0));
        if (args.size() > 1){
            varName = args.get(1);
        }else
            varName = "";
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        if (varName.equals("")){
            virtualMachine.push(value);
        }else
            virtualMachine.push(0);
    }
}
