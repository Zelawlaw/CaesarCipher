package org.romaninteligence.com;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EncodeTest {

    private Encode encodeObj;

    @BeforeAll
    void setupBeforeTests() {
        encodeObj = new Encode();
        assertNotNull(encodeObj);
    }

    @Test
    void checkInitialization() {
        //checks if decode Object was setup correctly.
    }

    @Test
    @DisplayName("It should encode String Fox String with key 23")
    void encodeFoxString() {

        int key = 23;
        String stringtoEncode = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
        String expectedEncoded = "QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD";
        encodeObj.setMessageToEncode(stringtoEncode);
        encodeObj.setKeyToEncode(key);
        assertEquals(expectedEncoded, encodeObj.encodeIt());
    }

    @Test
    @DisplayName("It should encode String Hi String with key 2")
    void encodeHiString() {

        int key = 2;
        String stringtoEncode = "HI";
        String expectedEncoded = "JK";
        encodeObj.setMessageToEncode(stringtoEncode);
        encodeObj.setKeyToEncode(key);
        assertEquals(expectedEncoded, encodeObj.encodeIt());
    }

    @Test
    @DisplayName("It should encode String HI String with key 20")
    void encodeHiString2() {

        int key = 20;
        String stringtoEncode = "HI";
        String expectedEncoded = "BC";
        encodeObj.setMessageToEncode(stringtoEncode);
        encodeObj.setKeyToEncode(key);
        assertEquals(expectedEncoded, encodeObj.encodeIt());
    }

    @Test
    @DisplayName("It should encode String hi String with key 20")
    void encodeHiString2LowerCase() {

        int key = 20;
        String stringtoEncode = "hi";
        String expectedEncoded = "bc";
        encodeObj.setMessageToEncode(stringtoEncode);
        encodeObj.setKeyToEncode(key);
        assertEquals(expectedEncoded, encodeObj.encodeIt());
    }

    @Test
    @DisplayName("It should encode String hi%lolo (Special Character) String with key 2")
    void encodeHiStringSpecialCharacterLowerCase() {

        int key = 2;
        String stringtoEncode = "hi%lolo";
        String expectedEncoded = "jk%nqnq";
        encodeObj.setMessageToEncode(stringtoEncode);
        encodeObj.setKeyToEncode(key);
        assertEquals(expectedEncoded, encodeObj.encodeIt());
    }

}