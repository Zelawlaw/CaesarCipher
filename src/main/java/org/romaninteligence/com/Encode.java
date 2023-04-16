package org.romaninteligence.com;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;


public class Encode {
       static final String REG_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       Map<Integer,Character> letterposition;

       public Encode (){
      //initialize letterposition on object creation
      this.letterposition = new HashMap<>();
      for(int i =0;i<REG_ALPHABET.length();i++){
        this.letterposition.put(i,REG_ALPHABET.charAt(i));
      }
       }

    public String encodeIt(String message, int key) {
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
            varchar = isLowerCase? Character.toUpperCase(varchar) :varchar;
            int currentposition = varchar - 'A';
            int encodedposition = (currentposition + key) % 26;
            if(isLowerCase)
            {
               sb.append(Character.toLowerCase(this.letterposition.get(encodedposition)));
            }
            else {
                sb.append(this.letterposition.get(encodedposition));
            }

            }

        }


        return sb.toString();
    }
}
