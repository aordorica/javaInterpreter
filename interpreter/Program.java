package interpreter;
import interpreter.bytecode.ByteCode;
import interpreter.bytecode.JumpCode;

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
        for (int i=0; i < program.size(); i++){
            if (program.get(i) instanceof JumpCode){
                String label = ((JumpCode) program.get(i)).getLabel();
                ((JumpCode) program.get(i)).setAddrs();
                System.out.println(((JumpCode) program.get(i)));
            }
        }
    }

    protected void add(ByteCode byteCode){
        program.add(byteCode);
    }

}
