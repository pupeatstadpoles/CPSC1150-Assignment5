/**
 * Program Name: SimpleMenu
 * Author: Pup Abdulgapul
 * Student ID: 100362791
 * Date: Oct 15, 2022
 * Course: CPSC1150-03
 * Professor: Hengameh Hamavand
 */
import java.util.Scanner;

public class SimpleMenu { //Program that takes in a string input from user then prompts them with a menu, and calls methods depending on the option chosen.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String string;
        int choice;
        boolean running = true;

        System.out.println("Please enter a sentence: ");
        string = input.nextLine();

        do {
            System.out.println("\nPlease choose an option by entering a number: \n1. To display the number of words in the sentence.\n2. To display the number of vowel characters in the sentence.\n3. To display the word with the most number of characters.\n4. To display the word with the most vowels.\n5. To enter a new statement.\n6. To terminate the program.");
            choice = input.nextInt();
            //input.nextLine();
            switch (choice) {
                case 1:
                    int words = wordCount(string);
                    System.out.println("\nThere are " + words + " words in the sentence.");
                    break;
                case 2:
                    int vowels = vowelCount(string);
                    System.out.println("\nThere are " + vowels + " vowel characters in the sentence.");
                    break;
                case 3:
                    String word = mostCharacters(string);
                    System.out.println("\nThe word with the most number of characters is " + word + ".");
                    break;
                case 4:
                    String wordVowel = mostVowels(string);
                    System.out.println("\nThe word with the most vowels in it is " + wordVowel + ".");
                    break;
                case 5:
                    System.out.println("\nPlease enter a new statement: ");
                    string = input.next();
                    break;
                case 6:
                    System.out.println("\nTerminating program.");
                    running = false;
                    break;
                default:
                    System.out.println("\nError: invalid input. Please make a choice from 1-6!");

            }
        } while (running == true);

        input.close();
    }
    
    
    /**
     * Counts the total number of words in the string
     * @param str the string entered by the user
     * @return number of words in the string
     */
    public static int wordCount(String str) {
        str = str.trim();
        int result = 0; // number of words

        if (str == null || str.isEmpty()) { // if theres nothing in the string
            return result;
        }

        else {
            result += 1;
            int space = str.indexOf(' '); // first occurence of a space in the string
            while (space >= 0) { // if theres no space left in the string, space=-1
                result++;
                str = str.substring(space + 1, str.length()); // convert to substring starting from next word
                str = str.trim(); // in case there are multiple spaces between words
                space = str.indexOf(' ');//checks if theres another word after this
            }
        }
        return result;
    }

    /**
     * Counts the total number of vowel characters in the string
     * @param str string entered by user
     * @return number of vowel characters
     */
    public static int vowelCount(String str) {
        str = str.toLowerCase();
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'|| str.charAt(i) == 'u') {
                result++; // increment result if any character is a vowel
            }
        }

        return result;
    }


    /**
     * Checks entire string for word with the most characters in it
     * @param str passes in a string for checking
     * @return the word with the most characters in it
     */
    public static String mostCharacters(String str) { 
        str = str.trim();
        str = str.toLowerCase();
        int length = 0, space = str.indexOf(' ');
        String word, result = "";

        while (space >= 0) { //should run as long as there is a word left
            word = str.substring(0, space);
            if (word.length() > length) { 
                length = word.length(); //sets length to the current highest letter count of all words parsed
                result = word; // if current word is longest so far, set result to word
            }
            str = str.substring(word.length(), str.length());//reset string to start from the end of the word that just got checked
            str = str.trim();
            space = str.indexOf(' ');//checks if theres another word after this
        }
        if (str.length()>length) { //checks if the last word is the longest
            result = str;
        }
        return result;
    }

    /**
     * Finding the word with the most vowels in it out of the entire string
     * @param str string entered by user
     * @return word with most vowels in it
     */
    public static String mostVowels(String str) {
        str = str.trim();
        str = str.toLowerCase();
        int vowels = 0, vowelsMost = 0, space = str.indexOf(' ');
        String word, result = ": there are no words with vowels in them";

        while (space >= 0) { //should run as long as theres another word after it
            word = str.substring(0, space);
            for (int i = 0; i < word.length(); i++) {
                if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'|| str.charAt(i) == 'u') {
                    vowels++;
                }
            }

            if (vowels > vowelsMost) {
                result = word;
            }

            str = str.substring(word.length(), str.length()); //reset string to start from the end of the word that just got checked
            str = str.trim();
            space = str.indexOf(' '); //checks if theres another word after this
        }
        
        vowels = 0;
        for (int i = 0; i < str.length(); i++){ //checking the last word for vowels
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'|| str.charAt(i) == 'u') {
                vowels++;
            }
        }

        if (vowels > vowelsMost){
            result = str;
        }

        return result;
    }
}
