package interpreter.bytecode;
import interpreter.VirtualMachine;

import java.util.*;

public abstract class ByteCode {

    public abstract void init(ArrayList<String> list);
    public abstract void execute(VirtualMachine virtualMachine);
}
