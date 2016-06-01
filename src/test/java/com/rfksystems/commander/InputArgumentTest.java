package com.rfksystems.commander;

import org.junit.Test;

import static org.junit.Assert.*;

public class InputArgumentTest {


    @Test
    public void has_value_returns_false_when_value_is_null() throws Exception {
        InputArgument inputArgument = new InputArgument(null);
        assertFalse(inputArgument.hasValue());
    }

    @Test
    public void has_value_returns_false_when_value_is_string_and_empty() throws Exception {
        InputArgument inputArgument = new InputArgument("");
        assertFalse(inputArgument.hasValue());
    }

    @Test
    public void has_value_returns_true_when_value_is_string() throws Exception {
        InputArgument inputArgument = new InputArgument("value");
        assertTrue(inputArgument.hasValue());
    }

    @Test
    public void it_returns_string_value_as_given_in_argument() throws Exception {
        InputArgument inputArgument = new InputArgument("value");
        assertEquals("value", inputArgument.getString());
    }

    @Test
    public void it_returns_null_value_from_get_string_if_string_value_is_null() throws Exception {
        InputArgument inputArgument = new InputArgument(null);
        assertNull(inputArgument.getString());
    }

    @Test
    public void it_returns_valid_integer_value() throws Exception {
        InputArgument inputArgument = new InputArgument(String.valueOf(Integer.MAX_VALUE));
        assertEquals(Integer.MAX_VALUE, inputArgument.getInt());
    }

    @Test(expected = NumberFormatException.class)
    public void it_throws_when_integer_value_can_not_be_retrieved() throws Exception {
        InputArgument inputArgument = new InputArgument(null);
        inputArgument.getInt();
    }

    @Test
    public void it_returns_valid_long_value() throws Exception {
        InputArgument inputArgument = new InputArgument(String.valueOf(Long.MAX_VALUE));
        assertEquals(Long.MAX_VALUE, inputArgument.getLong());
    }


    @Test(expected = NumberFormatException.class)
    public void it_throws_when_long_value_can_not_be_retrieved() throws Exception {
        InputArgument inputArgument = new InputArgument(null);
        inputArgument.getLong();
    }

    @Test
    public void it_returns_valid_double_value() throws Exception {
        InputArgument inputArgument = new InputArgument(String.valueOf(0.44D));
        assertEquals(0.44D, inputArgument.getDouble(), 0);
    }

    @Test(expected = NumberFormatException.class)
    public void it_throws_when_double_value_can_not_be_retrieved() throws Exception {
        InputArgument inputArgument = new InputArgument(null);
        inputArgument.getDouble();
    }

    @Test
    public void it_returns_boolean_true_if_value_string_value_of_true() throws Exception {
        InputArgument inputArgument = new InputArgument("true");
        assertTrue(inputArgument.getBoolean());
    }

    @Test
    public void it_returns_boolean_false_if_value_string_value_of_false() throws Exception {
        InputArgument inputArgument = new InputArgument("false");
        assertFalse(inputArgument.getBoolean());
    }

    @Test
    public void it_returns_boolean_false_if_value_string_value_not_boolean_value() throws Exception {
        InputArgument inputArgument = new InputArgument("yes");
        assertFalse(inputArgument.getBoolean());
    }

    @Test
    public void it_returns_valid_float_value() throws Exception {
        InputArgument inputArgument = new InputArgument(String.valueOf(0.44F));
        assertEquals(0.44F, inputArgument.getFloat(), 0);
    }

    @Test(expected = NumberFormatException.class)
    public void it_throws_when_float_value_can_not_be_retrieved() throws Exception {
        InputArgument inputArgument = new InputArgument(null);
        inputArgument.getFloat();
    }

    @Test
    public void it_returns_valid_short() throws Exception {
        InputArgument inputArgument = new InputArgument(String.valueOf(Short.MAX_VALUE));
        assertEquals(Short.MAX_VALUE, inputArgument.getShort(), 0);
    }

    @Test(expected = NumberFormatException.class)
    public void it_throws_when_short_value_can_not_be_retrieved() throws Exception {
        InputArgument inputArgument = new InputArgument(null);
        inputArgument.getShort();
    }

    @Test
    public void it_returns_valid_char() throws Exception {
        InputArgument inputArgument = new InputArgument("x");
        assertEquals('x', inputArgument.getChar());
    }

    @Test
    public void it_returns_valid_byte() throws Exception {
        InputArgument inputArgument = new InputArgument(String.valueOf(Byte.MAX_VALUE));
        assertEquals(Byte.MAX_VALUE, inputArgument.getByte());
    }

    @Test(expected = NumberFormatException.class)
    public void it_throws_when_byte_value_can_not_be_retrieved() throws Exception {
        InputArgument inputArgument = new InputArgument(null);
        inputArgument.getByte();
    }

    @Test
    public void it_returns_valid_list_of_values_by_delimiter() throws Exception {
        InputArgument inputArgument = new InputArgument("a,b,c");
        assertArrayEquals(new String[]{"a", "b", "c"}, inputArgument.getValueList(","));
    }

    @Test
    public void it_returns_valid_list_of_values_by_delimiter_and_limit() throws Exception {
        InputArgument inputArgument = new InputArgument("a,b,c");
        assertArrayEquals(new String[]{"a", "b,c"}, inputArgument.getValueList(",", 2));
    }

    @Test
    public void it_has_valid_to_string() throws Exception {
        InputArgument inputArgument = new InputArgument("value");
        assertEquals("value", inputArgument.toString());
    }

}