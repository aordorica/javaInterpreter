
package interpreter;

import interpreter.bytecode.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program; //program object where we store ByteCode objects from loadCodes after reading them from the file
    private StringTokenizer token;
    private ArrayList<String> arguments;
    private String code, className, line;
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO ReadCode FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */


    // Sample code for scanner to read file or keyboard input from source code provided in class. fine-tune later
    public Program loadCodes() {
        try {
            program = new Program();
            //Creat arraylist object to store the tokenized arguments from each line
            arguments = new ArrayList<String>();
            // Read first line for the file
            line = byteSource.readLine();
            // Loop to parse the current line into tokens and match to ByteCode from CodeTable
            while(line != null) {

                //Instantiate tokenizer object with string argument "line" to be tokenized
                token = new StringTokenizer(line);
                arguments.clear();
                code = token.nextToken();
                className = CodeTable.getClassName(code);

                //loop while line has more words or tokens to read
                while(token.hasMoreTokens()){
                    arguments.add(token.nextToken());
                }
                // Obtain class blueprint for the class matching the string bytecode token
                Class c = Class.forName("interpreter.bytecode." + className);
                ByteCode bytecode = (ByteCode) c.getDeclaredConstructor().newInstance();
                bytecode.init(arguments);
                program.add(bytecode);
              /*  try {
                    // Obtain class blueprint for the class matching the string bytecode token
                    Class c = Class.forName("interpreter.bytecode." + className);
                    // Instantiate bytecode class using specific subclasses from class token
                    ByteCode bytecode = (ByteCode) c.getDeclaredConstructor().newInstance();
                    // Pass bytecode arguments to designated bytecode subclass's init() function
                    bytecode.init(arguments);
                    program.add(bytecode);
                    // Catch all exceptions while instantiating byteCode subclasses and print out message
                } catch (Exception e) {
                    System.out.println(e.getMessage()); // Print out exceptions to console
                }*/
                // Read the next line from the file
                line = byteSource.readLine();
            }
        } catch (Exception e) {
            //Print exception message to console
           System.out.println(e.getMessage());
        }

        program.resolveAddrs();
        return program;
    }
}
