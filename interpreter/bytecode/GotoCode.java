package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends JumpCode {
    private String label;
    private int address;

    public void init(ArrayList<String> args) {
        label = args.get(0);
        address = 0;
    }

    public void execute(VirtualMachine virtualMachine) {
       // virtualMachine
    }

    @Override
    public String getLabel(){
        return this.label;
    }

    @Override
    public void setAddress(int address) {
        this.address = address + 1;
    }
}
