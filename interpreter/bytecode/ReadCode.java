package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadCode extends ByteCode {
    @Override
    public void init(ArrayList<String> list) {

    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        //ask the user to enter an integer
        System.out.print("Please input an integer: ");

        try {
            BufferedReader in = new BufferedReader( new InputStreamReader(System.in ) );
            String line = in.readLine();
            virtualMachine.push(Integer.parseInt(line));
        } catch( IOException e ) {
            System.out.println("Entered Value is not Valid!");
            System.out.println(e);
        }

    }
}
