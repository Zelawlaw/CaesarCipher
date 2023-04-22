package org.romaninteligence.com;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DecodeTest {
    private Decode decodeObj;

    @BeforeAll
    void setupBeforeTests() {
        decodeObj = new Decode();
        assertNotNull(decodeObj);
    }

    @Test
    void checkInitialization() {
        //checks if decode Object was setup correctly.
    }

    @Test
    @DisplayName("It should decode String QEB... String with key 23")
    void decodeFoxString() {
        int key = 23;
        String expected = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
        String stringtodecode = "QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD";
        decodeObj.setMessageToDecode(stringtodecode);
        decodeObj.setKeyToDecode(key);
        assertEquals(expected, decodeObj.decodeIt());
    }

    @Test
    @DisplayName("It should decode String JK String with key 2")
    void decodeHiString() {

        int key = 2;
        String expected = "HI";
        String stringtodecode = "JK";
        decodeObj.setMessageToDecode(stringtodecode);
        decodeObj.setKeyToDecode(key);
        assertEquals(expected, decodeObj.decodeIt());
    }

    @Test
    @DisplayName("It should decode String BC String with key 20")
    void decodeHiString2() {
        //    Decode decodeObj = new Decode();
        int key = 20;
        String expected = "HI";
        String stringtodecode = "BC";
        decodeObj.setMessageToDecode(stringtodecode);
        decodeObj.setKeyToDecode(key);
        assertEquals(expected, decodeObj.decodeIt());
    }

    @Test
    @DisplayName("It should decode String bc String with key 20")
    void decodeHiString2LowerCase() {
        //    Decode decodeObj = new Decode();
        int key = 20;
        String expected = "hi";
        String stringtodecode = "bc";
        decodeObj.setMessageToDecode(stringtodecode);
        decodeObj.setKeyToDecode(key);
        assertEquals(expected, decodeObj.decodeIt());
    }

    @Test
    @DisplayName("It should decode String jk%nqnq (Special Character) String with key 2")
    void decodeHiStringSpecialCharacterLowerCase() {
        //    Decode decodeObj = new Decode();
        int key = 2;
        String expected = "hi%lolo";
        String stringtodecode = "jk%nqnq";
        decodeObj.setMessageToDecode(stringtodecode);
        decodeObj.setKeyToDecode(key);
        assertEquals(expected, decodeObj.decodeIt());
    }
}