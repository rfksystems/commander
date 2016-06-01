package com.rfksystems.commander;


import com.rfksystems.commander.command.HelpCommand;
import com.rfksystems.commander.exception.CommandUnknownException;
import com.rfksystems.commander.exception.InputParseException;
import com.rfksystems.commander.exception.NoCommandGivenException;
import com.rfksystems.commander.exception.RuntimeArgumentException;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Commander {
    private HashMap<String, Command> commands = new HashMap<>();
    private Command defaultCommand;
    private String appDescription = null;

    public Commander() {
        Command helpCommand = new HelpCommand(this);
        this.addCommand(helpCommand);
        this.defaultCommand = helpCommand;
    }

    public Commander addCommand(Command command) {
        String commandName = command.getName();
        if (commands.containsKey(commandName)) {
            throw new RuntimeException(String.format("Command already registered: %s", commandName));
        }
        this.commands.put(commandName, command);
        return this;
    }

    public int execute(String[] args) throws NoCommandGivenException, CommandUnknownException, InputParseException, RuntimeArgumentException {
        return this.execute(args, System.out);
    }

    public int execute(String[] args, PrintStream output) throws NoCommandGivenException, CommandUnknownException, InputParseException, RuntimeArgumentException {

        String[] inputArgs = new String[0];
        if (args.length > 0) {
            inputArgs = Arrays.copyOfRange(args, 1, args.length);
        }

        Input input = new Input(inputArgs);

        if (args.length == 0) {
            if (defaultCommand == null) {
                throw new NoCommandGivenException();
            }
            return defaultCommand.execute(input, output);
        }

        String invokedCommand = args[0];

        if (!commands.containsKey(invokedCommand)) {
            throw new CommandUnknownException();
        }

        return commands.get(invokedCommand).execute(input, output);
    }

    public void printHelp() {
        printHelp(System.out);
    }

    public void printHelp(final PrintStream output) {
        if (this.appDescription != null) {
            output.println(this.appDescription);
        }
        output.println("Usage: ");

        for (Map.Entry<String, Command> commandEntry : commands.entrySet()) {
            Command command = commandEntry.getValue();
            String usage = command.getUsage();
            String description = command.getDescription();

            output.println(String.format(
                    "\t%s: %s",
                    commandEntry.getKey(),
                    usage == null ? "" : usage
            ));
            if (null != description) {
                output.println(String.format("\t\t%s", description));
            }
        }
    }

    public void setDefaultCommand(Command defaultCommand) {
        this.defaultCommand = defaultCommand;
    }

    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription;
    }
}
