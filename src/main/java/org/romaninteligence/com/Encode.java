package org.romaninteligence.com;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Data
public class Encode {
    static final String REG_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    Map<Integer, Character> letterposition;

    private String messageToEncode;
    private int keyToEncode;

    public Encode() {
        //initialize letterposition on object creation
        this.letterposition = new HashMap<>();
        for (int i = 0; i < REG_ALPHABET.length(); i++) {
            this.letterposition.put(i, REG_ALPHABET.charAt(i));
        }
    }

    public String encodeIt() {
        String message = this.getMessageToEncode();
        int key = this.getKeyToEncode();
        String encodedMessage = " ";
        StringBuilder sb = new StringBuilder();
        char[] messagechars = message.toCharArray();
        for (char varchar : messagechars) {
            if (!Character.isLetter(varchar)) {
                //not a letter. append to sb and continue
                sb.append(varchar);
                continue;
            } else {
                //it's a letter. encode
                //mark lowercase flag
                boolean isLowerCase = Character.isLowerCase(varchar);
                varchar = isLowerCase ? Character.toUpperCase(varchar) : varchar;
                int currentposition = varchar - 'A';
                int encodedposition = (currentposition + key) % 26;
                if (isLowerCase) {
                    sb.append(Character.toLowerCase(this.letterposition.get(encodedposition)));
                } else {
                    sb.append(this.letterposition.get(encodedposition));
                }

            }

        }


        return sb.toString();
    }
}
