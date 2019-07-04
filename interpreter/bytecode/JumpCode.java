package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class JumpCode extends ByteCode {

    String label;
    int address;
    @Override
    public void Init(ArrayList<String> args) {
        label = args.get(1);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {

    }

    public String getLabel(){
        return this.label;
    }

    public void setAddrs(){

    }
}
