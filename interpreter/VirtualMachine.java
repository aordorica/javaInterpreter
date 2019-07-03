package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.DumpCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram(){
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        while(isRunning){
            //keep vm running code here
            ByteCode code = program.getCode(pc);
            code.execute(this);
            if (this.dumpState && !(code instanceof DumpCode)){
                System.out.println(code);
                runStack.dump();
            }
            pc++;
        }
    }

    public void haltProgram(){
            this.isRunning = false;
    }

    public void newFrameAt(int num){
        this.newFrameAt(num);
    }

}
