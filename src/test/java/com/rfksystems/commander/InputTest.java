package com.rfksystems.commander;

import com.rfksystems.commander.exception.InputParseException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class InputTest {

    @Test
    public void it_properly_parses_positionals() throws Exception {
        Input input = new Input(new String[]{
                "a", "b", "c"
        });

        assertEquals(0, input.arguments.size());
        assertEquals(3, input.positional.size());
        assertEquals("a", input.positional.get(0));
        assertEquals("b", input.positional.get(1));
        assertEquals("c", input.positional.get(2));
    }

    @Test
    public void it_properly_parses_arguments() throws Exception {
        Input input = new Input(new String[]{
                "--no_value", "--value=yes"
        });

        assertEquals(0, input.positional.size());
        assertEquals(2, input.arguments.size());
        assertEquals("yes", input.arguments.get("value").getString());
        assertNull(input.arguments.get("no_value").getString());
    }

    @Test
    public void it_properly_parses_mixed() throws Exception {
        Input input = new Input(new String[]{
                "a", "--no_value", "b", "--value=yes", "c"
        });

        assertEquals(3, input.positional.size());
        assertEquals("a", input.positional.get(0));
        assertEquals("b", input.positional.get(1));
        assertEquals("c", input.positional.get(2));

        assertEquals(2, input.arguments.size());
        assertEquals("yes", input.arguments.get("value").getString());
        assertNull(input.arguments.get("no_value").getString());
    }

    @Test
    public void it_properly_parses_more_than_one_equals() throws Exception {
        Input input = new Input(new String[]{
                "--value=yes=more"
        });

        assertEquals(1, input.arguments.size());
        assertEquals("yes=more", input.arguments.get("value").getString());
    }
}