# Commander

Simple command line option parser and GIT-alike command manager for JDK7+.

[![Maven Central](https://img.shields.io/maven-central/v/com.rfksystems/commander.svg?style=flat-square)](http://mvnrepository.com/artifact/com.rfksystems/commander) [![Build Status](https://travis-ci.org/rfksystems/commander.svg?branch=master)](https://travis-ci.org/rfksystems/commander)

## Example usage

```java
import com.rfksystems.commander.Command;
import com.rfksystems.commander.Commander;
import com.rfksystems.commander.Input;
import com.rfksystems.commander.exception.*;

import java.io.PrintStream;

public class Main {
    public static void main(final String[] args) {
        final Commander commander = new Commander();
        commander.addCommand(new Command() {
            public String getName() {
                return "hello";
            }

            public String getUsage() {
                return "[--world]";
            }

            public String getDescription() {
                return "Some command that says hello";
            }

            public int execute(Input input, PrintStream output) throws RuntimeArgumentException {
                final String outputString = "Hello";
                if (input.arguments.containsKey("world")) {
                    outputString = outputString.concat(" world!");
                }
                output.println(outputString);
                return 0;
            }
        });
        try {
            commander.execute(args, System.out);
        } catch (final NoCommandGivenException | CommandUnknownException | RuntimeArgumentException | InputParseException e) {
            e.printStackTrace();
        }
    }
}

```

## Installation

### Maven

Available in Maven Central since 1.0.5

```xml
<dependency>
    <groupId>com.rfksystems</groupId>
    <artifactId>commander</artifactId>
    <version>${commander.version}</version>
</dependency>
```

### License

Apache License, Version 2.0
