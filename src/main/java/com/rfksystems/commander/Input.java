package com.rfksystems.commander;


import com.rfksystems.commander.exception.InputParseException;

import java.util.ArrayList;
import java.util.HashMap;

public class Input {
    public final ArrayList<String> positional = new ArrayList<>();
    public final HashMap<String, InputArgument> arguments = new HashMap<>();

    public Input(String[] args) throws InputParseException {
        for (String arg : args) {
            int substringOffset = 0;
            boolean isPositional = true;
            if (arg.startsWith("--")) {
                substringOffset = 2;
                isPositional = false;
            } else if (arg.startsWith("-")) {
                substringOffset = 1;
                isPositional = false;
            }

            arg = arg.substring(substringOffset);

            if (isPositional) {
                positional.add(arg);
            } else {
                if (arg.contains("=")) {
                    String[] split = arg.split("=");
                    if (split.length > 2) {
                        throw new InputParseException(String.format("Unexpected \"=\" while parsing \"%s\"", arg));
                    } else {
                        arguments.put(split[0], new InputArgument(split[1]));
                    }
                } else {
                    arguments.put(arg, new InputArgument(null));
                }
            }

        }
    }
}
