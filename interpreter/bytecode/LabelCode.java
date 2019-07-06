package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode {

    private String label;
    private int address;
    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
        address = 0;
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {

    }

    public String getLabel() {
        return this.label;
    }
}
