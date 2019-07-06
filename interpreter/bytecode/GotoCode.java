package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends JumpCode {
    private String label;
    private int address;
    private ArrayList<String> addrsArguments;

    public void init(ArrayList<String> args) {
        addrsArguments = args;
        label = addrsArguments.get(0);
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
    public void setAddrs(int adrss) {
        this.address = adrss;
    }
}
