package com.rfksystems.commander;


import com.rfksystems.commander.exception.RuntimeArgumentException;

import java.io.PrintStream;

public interface Command {
    String getName();

    String[] getUsage();

    String getDescription();

    int execute(final Input input, final PrintStream output) throws RuntimeArgumentException;
}
