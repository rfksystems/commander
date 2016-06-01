package com.rfksystems.commander.command;

import com.rfksystems.commander.Command;
import com.rfksystems.commander.Commander;
import com.rfksystems.commander.Input;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;

import static org.junit.Assert.*;

public class HelpCommandTest {
    private HelpCommand helpCommand;
    private Commander commander;
    private Input input;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        input = Mockito.mock(Input.class);
        printStream = Mockito.mock(PrintStream.class);
        commander = Mockito.mock(Commander.class);
        helpCommand = new HelpCommand(commander);
    }

    @After
    public void tearDown() throws Exception {
        helpCommand = null;
        commander = null;
    }

    @Test
    public void it_is_command() throws Exception {
        assertTrue(helpCommand instanceof Command);
    }

    @Test
    public void it_has_default_name() throws Exception {
        assertEquals("help", helpCommand.getName());
    }

    @Test
    public void it_has_no_extra_usage_info() throws Exception {
        assertNull(helpCommand.getUsage());
    }

    @Test
    public void it_has_description() throws Exception {
        assertEquals("Display command usage information", helpCommand.getDescription());
    }

    @Test
    public void it_invokes_commander_help_info() throws Exception {
        int status = helpCommand.execute(input, printStream);
        assertEquals(0, status);
        Mockito.verify(commander).printHelp(printStream);
    }

}