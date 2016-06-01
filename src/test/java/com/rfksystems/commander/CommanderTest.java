package com.rfksystems.commander;

import com.rfksystems.commander.exception.RuntimeArgumentException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class CommanderTest {
    private Commander commander;

    @Before
    public void setUp() throws Exception {
        commander = new Commander();
    }

    @After
    public void tearDown() throws Exception {
        commander = null;
    }

    @Test
    public void it_accepts_and_executes_command() throws Exception {
        commander.addCommand(new Command() {
            @Override
            public String getName() {
                return "test";
            }

            @Override
            public String[] getUsage() {
                return null;
            }

            @Override
            public String getDescription() {
                return null;
            }

            @Override
            public int execute(Input input, PrintStream output) throws RuntimeArgumentException {
                return -99;
            }
        });
        int result = commander.execute(new String[]{"test"});
        assertEquals(-99, result);
    }

    @Test
    public void it_accepts_and_executes_command_with_specified_print_stream() throws Exception {
        final PrintStream printStream = Mockito.mock(PrintStream.class);

        commander.addCommand(new Command() {
            @Override
            public String getName() {
                return "test";
            }

            @Override
            public String[] getUsage() {
                return null;
            }

            @Override
            public String getDescription() {
                return null;
            }

            @Override
            public int execute(Input input, PrintStream output) throws RuntimeArgumentException {
                assertEquals(printStream, output);
                return 0;
            }
        });
        commander.execute(new String[]{"test"}, printStream);
    }


    @Test
    public void it_sets_default_command() throws Exception {
        Command mockCommand = new Command() {
            @Override
            public String getName() {
                return "test";
            }

            @Override
            public String[] getUsage() {
                return null;
            }

            @Override
            public String getDescription() {
                return null;
            }

            @Override
            public int execute(Input input, PrintStream output) throws RuntimeArgumentException {
                return 0;
            }
        };

        commander.setDefaultCommand(mockCommand);
        commander.execute(new String[]{});
    }
}