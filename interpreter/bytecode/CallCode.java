package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends JumpCode{
    private String label;
    private int address;

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.pushReturnAddrs();
        virtualMachine.setPC(address);
    }

    public String getLabel(){
        return this.label;
    }

    @Override
    public void setAddress(int address) {
        this.address = address + 1;
    }
}
