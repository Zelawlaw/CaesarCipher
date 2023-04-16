package org.romaninteligence.com;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EncodeTest {

    @Test
    @DisplayName("It should encode String Fox String with key 23")
    void encodeFoxString() {
        Encode encodeObj = new Encode();
        int key = 23;
        String stringtoEncode = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
        String expectedEncoded = "QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD";
        assertEquals(expectedEncoded, encodeObj.encodeIt(stringtoEncode, key));
    }

    @Test
    @DisplayName("It should encode String Hi String with key 2")
    void encodeHiString() {
        Encode encodeObj = new Encode();
        int key = 2;
        String stringtoEncode = "HI";
        String expectedEncoded = "JK";
        assertEquals(expectedEncoded, encodeObj.encodeIt(stringtoEncode, key));
    }

    @Test
    @DisplayName("It should encode String HI String with key 20")
    void encodeHiString2() {
        Encode encodeObj = new Encode();
        int key = 20;
        String stringtoEncode = "HI";
        String expectedEncoded = "BC";
        assertEquals(expectedEncoded, encodeObj.encodeIt(stringtoEncode, key));
    }

    @Test
    @DisplayName("It should encode String hi String with key 20")
    void encodeHiString2LowerCase() {
        Encode encodeObj = new Encode();
        int key = 20;
        String stringtoEncode = "hi";
        String expectedEncoded = "bc";
        assertEquals(expectedEncoded, encodeObj.encodeIt(stringtoEncode, key));
    }

    @Test
    @DisplayName("It should encode String hi%lolo (Special Character) String with key 2")
    void encodeHiStringSpecialCharacterLowerCase() {
        Encode encodeObj = new Encode();
        int key = 2;
        String stringtoEncode = "hi%lolo";
        String expectedEncoded = "jk%nqnq";
        assertEquals(expectedEncoded, encodeObj.encodeIt(stringtoEncode, key));
    }

}