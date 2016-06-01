# Commander

Simple command line option parser and GIT-alike command manager.

[![Release](https://jitpack.io/v/com.github.rfksystems/commander.svg?style=flat-square)](https://jitpack.io/#com.github.rfksystems/commander)

## Example usage


```java
import com.rfksystems.commander.Command;
import com.rfksystems.commander.Commander;
import com.rfksystems.commander.Input;
import com.rfksystems.commander.exception.*;

import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        Commander commander = new Commander();
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
                String outputString = "Hello";
                if (input.arguments.containsKey("world")) {
                    outputString = outputString.concat(" world!");
                }
                output.println(outputString);
                return 0;
            }
        });
        try {
            commander.execute(args, System.out);
        } catch (NoCommandGivenException | CommandUnknownException | RuntimeArgumentException | InputParseException e) {
            e.printStackTrace();
        }
    }
}

```

## Installation

### Maven

Add the repository:

```xml
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>
```

Add the dependency:


```xml
<dependency>
    <groupId>com.github.rfksystems</groupId>
    <artifactId>commander</artifactId>
    <version>${commander.version}</version>
</dependency>
```

### Other managers

See [https://jitpack.io](https://jitpack.io)


### License

Apache License, Version 2.0