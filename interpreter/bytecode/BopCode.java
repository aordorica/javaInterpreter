package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {
    private int result;
    private String op;

    private ArrayList<String> arguments;
    @Override
    public void init(ArrayList<String> args) {
        op = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        int operand1 = vm.pop();
        int operand2 = vm.pop();

        switch (op) {
            case "+":
                result = operand2 + operand1;
                break;
            case "-":
                result = operand2 - operand1;
                break;
            case "*":
                result = operand2 * operand1;
                break;
            case "/":
                result = operand2 / operand1;
                break;
            case "==":
                if (operand2 == operand1){
                    result = 1;
                }else
                    result = 0;
                break;
            case "!=":
                if (operand2 != operand1){
                    result = 1;
                }else
                    result = 0;
                break;
            case "<=":
                if (operand2 <= operand1){
                    result = 1;
                }else
                    result = 0;
                break;
            case ">=":
                if (operand2 >= operand1){
                    result = 1;
                }else
                    result = 0;
                break;
            case "<":
                if (operand2 < operand1){
                    result = 1;
                }else
                    result = 0;
                break;
            case ">":
                if (operand2 > operand1){
                    result = 1;
                }else
                    result = 0;
                break;
            case "|":
                if ((operand2 > 0) && (operand1 > 0)){
                    result = 1;
                }else
                    result = 0;
                break;
            case "&":
                if ((operand2 > 0) || (operand1 > 0)){
                    result = 1;
                }else
                    result = 0;
                break;
        }
        vm.push(result);

    }
}
