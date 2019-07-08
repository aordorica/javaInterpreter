package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump(){
        //Void function used to dump the current state of the
        //RuntimeStack. When printing the runtime stack make sure to include divisions between frames
        //If a frame is empty, this  ust be shown as well.
    }
    public int peek(){
        return runTimeStack.get(runTimeStack.size()-1); //returns top of stack
    }
    public void newFrameAt(int offset){
        //creates a new frame in the RuntimeStack class. The
        //parameter offset is used to denote how many slots down
        //from the top of RuntimeStack for starting a new frame.
        framePointer.push(runTimeStack.size() - offset);
    }
    public void popFrame(){
        // we pop the top frame when we return from a function.
        // Before popping, the function’s return value is at the top of the stack,
        // so we’ll save the value, then pop the top frame and then push the return value back onto the stack.
        // It is assumed return values are at the top of the stack.
        int topStack = this.peek();
        while((runTimeStack.size() -1) >= framePointer.pop()){
            if (!runTimeStack.isEmpty()){
                this.pop();
            }
        }
        this.push(topStack);
    }
    public int store(int offset) {
        //Used to store values into variables. Store will pop the
        //top value of the stack and replace the value at the given offset in the current frame. The value stored is returned.
        int value = this.pop();
        runTimeStack.set(framePointer.peek() + offset, value);
        return value;
    }
    public int load(int offset){
        // Used to load variables onto the RuntimeStack from a given offset within the current frame.
        // This means we will go to the offset in the current frame, copy the value and push it to the top of the stack.
        // No values should be removed with load.
       int temp = runTimeStack.get(framePointer.peek() + offset);
       runTimeStack.add(temp);
       return temp;
    }
    public Integer push(Integer val){
        //Used to load literal values onto the RuntimeStack. For
        //example, LIT 5 or LIT 0 will call push with val being 5 or val being 0.
        runTimeStack.add(val);
        return val;
    }

    public int pop(){
        return runTimeStack.remove(runTimeStack.size()-1);
    }
}
