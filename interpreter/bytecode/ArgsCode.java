package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {

    private ArrayList<String> arguments;
    private int numArgs;

    @Override
    public void Init(ArrayList<String> args) {
        arguments = args;
    }

    @Override
    public void execute(VirtualMachine vm) {
       // vm.newRTS_Frame(numArgs); //Calls function in VM/RTS classes that creates new frame
    }
}
