package org.romaninteligence.com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Encode encodeObj = new Encode();
        Decode decodeObj = new Decode();
        boolean keepWorking = true;
        String message = "";
        int key = 0;
        int stage = 0;

        while (keepWorking) {
            try {
                switch (stage) {
                    case 0:
                        System.out.println("\nWould you like to encode or decode? press 'e' for encode and 'd' for decode." +
                                "press x to exit");
                        System.out.println("has next lines: "+in.hasNext());
                      //  in.nextLine();
                        String action = in.nextLine();

                        if (action.equalsIgnoreCase("e")) {
                            stage = 1;
                        } else if (action.equalsIgnoreCase("d")) {
                            stage = 2;
                        } else if (action.equalsIgnoreCase("x")) {
                            System.out.println("Exiting system. good bye!");
                            keepWorking = false;
                        } else {
                            System.out.println("wrong input!"+action.length()+" here");
                        }
                        break;

                    case 1:
                        System.out.println("Enter message to encode ");
                        message = in.nextLine();
                        stage = 3;
                        break;

                    case 2:
                        System.out.println("Enter message to decode ");
                        message = in.nextLine();
                        stage = 4;
                        break;

                    case 3:

                        System.out.println("Enter key to encode");

                        key = in.nextInt();
                        encodeObj.setKeyToEncode(key);
                        encodeObj.setMessageToEncode(message);
                        System.out.println("Encoded message is :");
                        System.out.println(encodeObj.encodeIt());
                        stage = 0;
                        in.reset();
                        break;

                    case 4:
                        System.out.println("Enter key to decode");

                        key = in.nextInt();
                        decodeObj.setKeyToDecode(key);
                        decodeObj.setMessageToDecode(message);
                        System.out.println("Decoded message is :\n");
                        System.out.println(decodeObj.decodeIt());
                        stage = 0;
                        in.reset();
                       break;

                }

            } catch (Exception Ex) {
                System.out.println("Exception " + Ex.getMessage() + " Occurred!\n");
                System.out.println("Would you like to continue?\n press any key to continue and x to exit");
                String command = in.nextLine();
                if(command.equalsIgnoreCase("x")){
                    System.out.println("Good bye!");
                    keepWorking = false;
                }
                else {
                    stage =0;
                }
            }


        }


    }
}



