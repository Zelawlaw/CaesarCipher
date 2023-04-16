package org.romaninteligence.com;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;


public class Decode {
    static final String REG_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Map<Integer,Character> letterposition;

    public Decode(){
        //initialize letterposition on object creation
        this.letterposition = new HashMap<>();
        for(int i =0;i<REG_ALPHABET.length();i++){
            this.letterposition.put((REG_ALPHABET.length()-1)-i,REG_ALPHABET.charAt(i));
        }
    }

    public String decodeIt(String encodedmessage, int key) {

        String encodedMessage = " ";
        StringBuilder sb = new StringBuilder();
        char[] messagechars = encodedmessage.toCharArray();
        for (char varchar : messagechars) {
            if (!Character.isLetter(varchar)) {
                //not a letter. append to sb and continue
                sb.append(varchar);
                continue;
            } else {
                //it's a letter. encode
                //mark lowercase flag
                boolean isLowerCase = Character.isLowerCase(varchar);
                varchar = isLowerCase? Character.toUpperCase(varchar) :varchar;
                int currentposition = 'Z' - varchar ;
                int decodedposition = (currentposition + key) % 26;
                if(isLowerCase)
                {
                    sb.append(Character.toLowerCase(this.letterposition.get(decodedposition)));
                }
                else {
                    sb.append(this.letterposition.get(decodedposition));
                }

            }

        }


        return sb.toString();

    }
}
