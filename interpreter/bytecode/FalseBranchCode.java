package interpreter.bytecode;

/* Purpose:
 FalseBranchCode <label> pop the top of the stack; if it is false (0) then
branch to <label> else execute the next bytecode */

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends JumpCode {
    String label;
    int address;
    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {

    }

    public String getLabel(){
        return this.label;
    }

    @Override
    public void setAddrs(int adrss) {
        this.address = adrss;
    }
}
