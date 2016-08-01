package com.robinpowered.sdk.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class BasicIdentifierTest {

    @Test
    public void testEqualsAndHashcode() {
        EqualsVerifier.forClass(BasicIdentifier.class)
                .usingGetClass()
                .verify();
    }
}
