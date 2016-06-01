package com.rfksystems.commander.command;


import com.rfksystems.commander.Command;
import com.rfksystems.commander.Commander;
import com.rfksystems.commander.Input;
import com.rfksystems.commander.exception.RuntimeArgumentException;

import java.io.PrintStream;

public class HelpCommand implements Command {
    private Commander commander;

    public HelpCommand(Commander commander) {
        this.commander = commander;
    }

    public String getName() {
        return "help";
    }

    public String[] getUsage() {
        return null;
    }

    public String getDescription() {
        return "Display command usage information";
    }

    public int execute(Input input, PrintStream output) throws RuntimeArgumentException {
        this.commander.printHelp(output);
        return 0;
    }
}
