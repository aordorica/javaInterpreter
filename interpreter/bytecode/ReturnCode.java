package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {

    String funcName;
    int returnVal;
    int returnAddrs;
    @Override
    public void init(ArrayList<String> args) {
        if (!args.isEmpty()){
            funcName = args.get(0);
        }
//        else
//            funcName = "";
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        returnVal = virtualMachine.peek();
        virtualMachine.setPC(virtualMachine.popReturnAddrs());
        virtualMachine.popFrame();
    }
}
