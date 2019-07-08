package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class JumpCode extends ByteCode {
    private String label;
    int address;
    public void init(ArrayList<String> args) {
    }
    @Override
    public void execute(VirtualMachine virtualMachine) {

    }

    public String getLabel(){ return label;
    }

    public void setAddress(int address) {
    }
}
