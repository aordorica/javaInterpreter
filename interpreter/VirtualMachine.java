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
            if (//this.dumpState && !
                    (code instanceof DumpCode)){
                System.out.println(code);
                runStack.dump();
            }
            pc++;
        }
    }

    public void haltProgram(){
            this.isRunning = false;
    }

    private void newFrameAt(int num){
        this.runStack.newFrameAt(num);
    }

    private void popFrame(){

    }

    private int store(int offset){
        return 0;
    }

    private int load(int offset){
        return 0;
    }

    private Integer push(Integer val){
        return 0;
    }
}
