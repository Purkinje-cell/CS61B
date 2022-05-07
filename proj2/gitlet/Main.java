package gitlet;

import static gitlet.Repository.*;

import java.io.IOException;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author TODO
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) throws IOException {
        // TODO: what if args is empty?
        if (args.length == 0) {
            System.out.println("Please enter a command.");
        }
        String firstArg = args[0];
        switch(firstArg) {
            case "init":
                init();
                // TODO: handle the `init` command
                break;
            case "add":
                String filename = args[1];
                add(filename);
                // TODO: handle the `add [filename]` command
                break;
            case "commit" :

                break;
            default:
                System.out.println("No command with that name exists.");
            // TODO: FILL THE REST IN
        }
    }
}
