package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {

    private ArrayList<String> arguments;
    private int numArgs;
    private String label;

    @Override
    public void init(ArrayList<String> args) {
        arguments = args;
        label = arguments.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
       // vm.newRTS_Frame(numArgs); //Calls function in VM/RTS classes that creates new frame
    }
}
