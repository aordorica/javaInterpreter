package interpreter;
import interpreter.bytecode.*;
import interpreter.bytecode.JumpCode;
import interpreter.bytecode.LabelCode;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;
    private HashMap<String, Integer> addressHashMap;

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
    void resolveAddrs() {
        addressHashMap = new HashMap<String, Integer>();
        for (int i=0; i < program.size(); i++){
            if (program.get(i) instanceof LabelCode){
                String label = ((LabelCode) this.program.get(i)).getLabel();
                addressHashMap.put(label, i);
            }
        }

        for (ByteCode byteCode : program) {
            if (byteCode instanceof JumpCode) {
                ((JumpCode) byteCode).setAddress(addressHashMap.get(((JumpCode) byteCode).getLabel()));
            }
        }

        System.out.println(program.iterator());
    }

    void add(ByteCode byteCode){
        program.add(byteCode);
    }

}
