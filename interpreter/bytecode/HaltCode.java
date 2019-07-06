package interpreter.bytecode;

/* Purpose:
 Halt the execution of program */

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode {
    public ArrayList<String> args;


    @Override
    public void init(ArrayList<String> arguments) {
        args = arguments;
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.haltProgram();
    }
}
