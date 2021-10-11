import java.util.Scanner;

public class Vigenere {
    public static char encryptCaesarLetter(char ch, int key) {
        String str = "" + ch;
        String enc = Caesar.encryptCaesarKey(str, key);
        return enc.charAt(0);
    }

    public static char decryptCaesarLetter(char ch, int key) {
        String str = "" + ch;
        String enc = Caesar.decryptCaesarKey(str, key);
        return enc.charAt(0);
    }
    public static String encryptVigenere(String message, String key) {
        String str = "";
        int KeyIndex = 0;
        for (int i = 0; i < message.length(); i ++){
            char x = message.charAt(i);
            int a;
            if ((x >= 'A' && x <= 'Z' || x>= 'a' && x<= 'z')){
                if (KeyIndex > key.length() - 1) {
                    a = KeyIndex % key.length();
                } else {
                    a = KeyIndex % key.length();
                }
                KeyIndex++;
//                System.out.println((int)message.charAt(i));
//                System.out.println((int)message.charAt(a));
                str += encryptCaesarLetter(message.charAt(i), key.charAt(a) - 'A');
//                str += (char)((int)message.charAt(i) + (int)message.charAt(a));
            } else {
                str += message.charAt(i);
            }
        }
        return str;

    }

    public static String decryptVigenere(String message, String key) {
        String str = "";
        int KeyIndex = 0;
        for (int i = 0; i < message.length(); i ++){
            char x = message.charAt(i);
            int a;
            if ((x >= 'A' && x <= 'Z' || x>= 'a' && x<= 'z')){
                if (KeyIndex > key.length() - 1) {
                    a = KeyIndex % key.length();
                } else {
                    a = KeyIndex % key.length();
                }
                KeyIndex++;
//                System.out.println((int)message.charAt(i));
//                System.out.println((int)message.charAt(a));
                str += decryptCaesarLetter(message.charAt(i), key.charAt(a) - 'A');//                str += (char)((int)message.charAt(i) + (int)message.charAt(a));
            } else {
                str += message.charAt(i);
            }
        }
        return str;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
