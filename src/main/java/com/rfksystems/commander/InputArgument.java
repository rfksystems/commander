package com.rfksystems.commander;

public class InputArgument {
    private String stringValue;

    public InputArgument(String stringValue) {
        this.stringValue = stringValue;
    }

    public boolean hasValue() {
        return stringValue != null && !stringValue.isEmpty();
    }

    public String getString() {
        return stringValue;
    }

    public char getChar() {
        return stringValue.charAt(0);
    }

    public String[] getValueList(String regex) {
        return stringValue.split(regex);
    }

    public String[] getValueList(String regex, int limit) {
        return stringValue.split(regex, limit);
    }


    public boolean getBoolean() {
        return Boolean.valueOf(stringValue);
    }

    public int getInt() throws NumberFormatException {
        return Integer.valueOf(stringValue);
    }

    public long getLong() throws NumberFormatException {
        return Long.valueOf(stringValue);
    }

    public double getDouble() throws NumberFormatException {
        try {
            return Double.valueOf(stringValue);
        } catch (NullPointerException e) {
            throw new NumberFormatException(e.getMessage());
        }
    }

    public float getFloat() throws NumberFormatException {
        try {
            return Float.valueOf(stringValue);
        } catch (NullPointerException e) {
            throw new NumberFormatException(e.getMessage());
        }
    }

    public short getShort() throws NumberFormatException {
        return Short.valueOf(stringValue);
    }

    public byte getByte() throws NumberFormatException {
        return Byte.valueOf(stringValue);
    }

    @Override
    public String toString() {
        return stringValue;
    }
}
