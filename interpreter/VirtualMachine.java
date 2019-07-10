package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.DumpCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack<Integer> returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean dumpState;

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
            ByteCode code = program.getCode(pc); // gets first ByteCode
            code.execute(this); // executes first ByteCode's execute method
            if (this.dumpState && !(code instanceof DumpCode)){
                System.out.println(code);
                runStack.dump();
            }
            pc++;
        }
    }

    public void setDump(Boolean dump){
        dumpState = dump;
    }
    public void haltProgram(){
        isRunning = false;
    }

    public void newFrameAt(int num){
        this.runStack.newFrameAt(num);
    }

    public void popFrame(){
        runStack.popFrame();
    }

    public int store(int offset){
        return runStack.store(offset);
    }

    public int load(int offset){
        return runStack.load(offset);
    }

    public Integer push(Integer val){
        return runStack.push(val);
    }

    public void setPC(int pc){
        this.pc = pc;
    }

    public int pop(){
        return runStack.pop();
    }

    public int peek(){
        return runStack.peek();
    }

    public int  pushReturnAddrs(){
        return returnAddrs.push(pc);
    }
    public int popReturnAddrs(){
        return returnAddrs.pop();
    }
}
