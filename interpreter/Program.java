package interpreter;
import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LabelCode <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     */
    public void resolveAddrs() {

    }

    protected void add(ByteCode byteCode){
        program.add(byteCode);
    }



}
