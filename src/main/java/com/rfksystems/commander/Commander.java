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
    private final HashMap<String, Command> commands = new HashMap<>();
    private Command defaultCommand;
    private String appDescription = null;

    public Commander() {
        final Command helpCommand = new HelpCommand(this);
        addCommand(helpCommand);
        defaultCommand = helpCommand;
    }

    public Commander addCommand(final Command command) {
        final String commandName = command.getName();

        if (commands.containsKey(commandName)) {
            throw new RuntimeException(String.format("Command already registered: %s", commandName));
        }

        commands.put(commandName, command);
        return this;
    }

    public Commander removeCommand(final Command command) {
        final String commandName = command.getName();

        if (!commands.containsKey(commandName)) {
            return this;
        }

        commands.remove(commandName);
        return this;
    }

    public boolean hasCommand(final Command command) {
        return commands.containsKey(command.getName());
    }

    public int execute(final String[] args)
            throws NoCommandGivenException,
            CommandUnknownException,
            InputParseException,
            RuntimeArgumentException {
        return execute(args, System.out);
    }

    public int execute(
            final String[] args,
            final PrintStream output
    ) throws NoCommandGivenException,
            CommandUnknownException,
            InputParseException,
            RuntimeArgumentException {

        String[] inputArgs = new String[0];

        if (0 < args.length) {
            inputArgs = Arrays.copyOfRange(args, 1, args.length);
        }

        final Input input = new Input(inputArgs);

        if (0 == args.length) {
            if (defaultCommand == null) {
                throw new NoCommandGivenException();
            }
            return defaultCommand.execute(input, output);
        }

        final String invokedCommand = args[0];

        if (!commands.containsKey(invokedCommand)) {
            throw new CommandUnknownException();
        }

        return commands
                .get(invokedCommand)
                .execute(input, output);
    }

    public void printHelp() {
        printHelp(System.out);
    }

    public void printHelp(final PrintStream output) {
        if (appDescription != null) {
            output.println(this.appDescription);
        }

        output.println("Usage:");

        for (final Map.Entry<String, Command> commandEntry : commands.entrySet()) {
            final Command command = commandEntry.getValue();
            final String[] usage = command.getUsage();
            final String description = command.getDescription();

            output.println("\t" + commandEntry.getKey().concat(": ").concat(description));

            if (null != usage) {
                for (final String usageItem : usage) {
                    output.println("\t\t" + usageItem);
                }
            }
        }
    }

    public void setDefaultCommand(final Command defaultCommand) {
        this.defaultCommand = defaultCommand;
    }

    public void setAppDescription(final String appDescription) {
        this.appDescription = appDescription;
    }
}
