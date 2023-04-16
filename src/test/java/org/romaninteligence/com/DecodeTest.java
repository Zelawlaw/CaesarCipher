package org.romaninteligence.com;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodeTest {

    @Test
    @DisplayName("It should decode String QEB... String with key 23")
    void encodeFoxString() {
        Decode decodeObj = new Decode();
        int key = 23;
        String expected = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
        String stringtodecode ="QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD";
        assertEquals(expected,decodeObj.decodeIt(stringtodecode,key));
    }

    @Test
    @DisplayName("It should decode String JK String with key 2")
    void encodeHiString() {
        Decode decodeObj = new Decode();
        int key = 2;
        String expected = "HI";
        String stringtodecode ="JK";
        assertEquals(expected,decodeObj.decodeIt(stringtodecode,key));
    }

    @Test
    @DisplayName("It should decode String BC String with key 20")
    void encodeHiString2() {
        Decode decodeObj = new Decode();
        int key = 20;
        String expected = "HI";
        String stringtodecode ="BC";
        assertEquals(expected,decodeObj.decodeIt(stringtodecode,key));
    }

    @Test
    @DisplayName("It should decode String bc String with key 20")
    void encodeHiString2LowerCase() {
        Decode decodeObj = new Decode();
        int key = 20;
        String expected = "hi";
        String stringtodecode ="bc";
        assertEquals(expected,decodeObj.decodeIt(stringtodecode,key));
    }

    @Test
    @DisplayName("It should decode String jk%nqnq (Special Character) String with key 2")
    void encodeHiStringSpecialCharacterLowerCase() {
        Decode decodeObj = new Decode();
        int key = 2;
        String expected = "hi%lolo";
        String stringtodecode ="jk%nqnq";
        assertEquals(expected,decodeObj.decodeIt(stringtodecode,key));
    }
}