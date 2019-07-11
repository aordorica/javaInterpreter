package interpreter.bytecode;

/* Purpose:
 FalseBranchCode <label> pop the top of the stack; if it is false (0) then
branch to <label> else execute the next bytecode */

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends JumpCode {
    private String label;
    private int address;
    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        if(virtualMachine.pop() == 0 ){
            virtualMachine.setPC(address);
        }
    }

    public String getLabel(){
        return this.label;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }
}
