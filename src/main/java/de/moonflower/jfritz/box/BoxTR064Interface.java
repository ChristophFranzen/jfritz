package de.moonflower.jfritz.box;

import java.io.IOException;

public interface BoxTR064Interface {
    boolean isTR064Available();
    boolean isDialAssistAvailable();
    boolean is2FAenabled() throws IOException, NoSuchFieldException;
    String getDialPort() throws IOException, NoSuchFieldException;
}
