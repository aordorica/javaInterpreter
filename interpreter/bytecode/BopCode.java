package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {

    private ArrayList<String> arguments;
    @Override
    public void init(ArrayList<String> args) {
        arguments = args;
    }

    @Override
    public void execute(VirtualMachine vm) {

    }
}
