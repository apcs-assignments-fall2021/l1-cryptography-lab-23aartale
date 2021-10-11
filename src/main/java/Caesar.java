import java.util.Scanner;

public class Caesar {
    // Given a String, encrypts the String with the Caesar cipher
    // and returns the encrypted String
    // Ex. encryptCaesar("Hello, World!") => "Khoor, Zruog!"
    public static String encryptCaesar(String message) {
        String str = "";
        for (int i = 0; i < message.length(); i++){
            char x = message.charAt(i);
            if (x >= 'A' && x <='W') {
                x += 3;
            }
            else if (x == 'X') {
                x = 'A';
            }
            else if (x == 'Y') {
                x = 'B';
            }
            else if (x == 'Z') {
                x = 'C';
            }
            else if (x >= 'a' && x <='w') {
                x += 3;
            }
            else if (x == 'x') {
                x = 'a';
            }
            else if (x == 'y') {
                x = 'b';
            }
            else if (x == 'z') {
                x = 'c';
            }

            str = str + x;
        }
        return str;
    }

    // Given a String, decrypts the String with the Caesar cipher
    // and returns the original String
    // Ex. decryptCaesar("Khoor, Zruog!") => "Hello, World!"
    public static String decryptCaesar(String message) {
        return decryptCaesarKey(message, 3);
//        String str = "";
//        for (int i = 0; i < message.length(); i++){
//            char x = message.charAt(i);
//            if (x >= 'D' && x <='Z') {
//                x -= 3;
//            }
//            else if (x == 'C') {
//                x = 'Z';
//            }
//            else if (x == 'B') {
//                x = 'Y';
//            }
//            else if (x == 'A') {
//                x = 'A';
//            }
//            else if (x >= 'd' && x <='z') {
//                x -= 3;
//            }
//            else if (x == 'c') {
//                x = 'z';
//            }
//            else if (x == 'b') {
//                x = 'y';
//            }
//            else if (x == 'a') {
//                x = 'a';
//            }
//
//            str = str + x;
//        }
//        return str;
    }

    // Given a String and a key corresponding to a shift, encrypts
    // the String using the given key and returns the encrypted String
    // Ex. encryptCaesarKey("Hello, World!", 5) => "Mjqqt, Btwqi!".
    public static String encryptCaesarKey(String message, int key) {
        String str = "";
        key = key % 26;
        for (int i = 0; i < message.length(); i++) {
            char x = message.charAt(i);
            if (! (x >= 'A' && x <= 'Z' || x>= 'a' && x<= 'z')) {
                x = x;
            }
            else if (x + key >= 'a' && x + key <= 'z') {
                x += key;
            }
            else if (x + key > 'z') {
                x -= (26 - key);
            }
            else if (x + key >= 'A' && x + key <= 'Z') {
                x += key;
            }
            else if (x + key > 'Z'){
                x -= (26 - key);
            }
            str = str + x;
        }
        return str;
    }

    // Given a String and a key corresponding to a shift, decrypts
    // the String using the given key and returns the original String
    // Ex. decryptCaesarKey("Mjqqt, Btwqi!", 5) => "Hello, World!"
    public static String decryptCaesarKey(String message, int key) {
        String str = "";
        key = key % 26;
        for (int i = 0; i < message.length(); i++) {
            char x = message.charAt(i);
            if (! (x >= 'A' && x <= 'Z' || x>= 'a' && x<= 'z')){
                x = x;
            }
            else if (x - key >= 'A' && x - key <= 'Z') {
                x -= key;
            }
            else if (x - key < 'A'){
                x += (26 - key);
            }
            else if (x - key >= 'a' && x - key <= 'z') {
                x -= key;
            }
            else if (x - key < 'a'){
                x += (26 - key);
            }
            str = str + x;
        }
        return str;
    }


    // The main method is already provided for you
    // You do not need to edit this code until Part 2
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println(encryptCaesarKey("Hello World", 5));
        System.out.println(decryptCaesarKey("Mjqqt Btwqi", 5));

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesar(message));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesar(message));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
