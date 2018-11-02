/*
Started October 19, 2018 || Frida Jauregui

write a program that will contaon methods of encrypting and decrypting text
 */

import java.util.*;

public class Crypto {
    public static void main(String[] args) {
        //take in string to be encrypted
        System.out.println(normalizeText("This is some \"really\" great. (Text)!?"));
        System.out.println(shiftAlphabet(2));
        System.out.println(caesarify("Frida", 1));   //"IUGD" with 3 shift
        System.out.println(groupify("HITHERE", 2)); //“HI TH ER Ex”
        System.out.println(encryptString("OK I GET IT", 2, 2)); //will use obi and cae functions
        System.out.println(ungroupify("THI SIS ARE ALL YGR EAT SEN TEN CEx"));   //"THISISAREALLYGREATSENTENCE"
        //PART5
        String cyphertext = encryptString("A",  1, 2);
        String plaintext = decryptString(cyphertext, 1);
        System.out.println(plaintext);
    }


    //PART1
    //normalize your input message
    public static String normalizeText(String s) {
        //remove spaces
        String s1 = s.replaceAll("\\s+", "");
        //remove special characters
        s1 = s1.replaceAll("[.,:;’\"!?()&@]", "");
        //turn lower case into uppercase
        s1 = s1.toUpperCase();
        //check if statements have changed the string
        //System.out.println(s1);
        return s1;
    }

    //obify & compare
    public static boolean compare(char c, char[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (c == array[i]) {
                return true;
            }
        }
        return false;
    }

    public static String obify(String s) {
        char[] vowels = {'A', 'E', 'I', 'O', 'U', 'Y'};
        String n = "";
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (compare(c, vowels)) {
                n += "OB" + c;
            }
            else {
                n += c;
            }
        }
        return n;
    }


    //PART2
    //provided function
    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for (; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if (result.length() < 26) {
            for (currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

    //caesar cipher
    public static String caesarify(String c, int key) {
        //should also have negative shift values
        //define blank text before the for loop, abcs and normalize
        String blank = "";
        String abcs = "abcdefghijklmnopqrstuvwxyz";
        c = c.toLowerCase();
        //for loop
        for (int i = 0; i < c.length(); i++) {
            //loop through each letter of the string
            //return the character located at the string's specified index
            int index = abcs.indexOf(c.charAt(i));
            //used provided function for the shift
            String shift = shiftAlphabet(index);
            System.out.print(shift.charAt(key));
        }
        return blank;
    }


    //PART3
    //codegroups
    public static String groupify(String g, int num) {
        //break a string into groups
        //assume string is normalized
        String blank = "";
        //for loop
        for (int i = 0; i < g.length(); i+=num) {
            if (i + num < g.length()) {
                //add a substring that will start at index i n will spilt it at the end index
                blank += g.substring(i, i + num);
                blank += " ";
                //padding un grouped characters with 'x'
            } else {
                //create another substring
                String blank2 = g.substring(i);
                blank += blank2;
                for (int j = 0; j < num - blank2.length(); j++) {
                    blank += 'x';
                }
            }
        }
        return blank;
    }


    //PART4
    //encrypt
    public static String encryptString(String en, int shift, int group){
        //code should do the following:
        //call normalizeText on the input string
        //call obify to obfuscate the normalized text
        //call caesarify to encrypt the obfuscated text
        //call groupify to break the cyphertext into groups of size letters
        String norm = normalizeText(en);
        String obi = obify(norm);
        String caesar = caesarify(obi,shift);
        return groupify(caesar, group);
    }



    //PART5
    //decrypt
    public static String ungroupify(String un) {
        //takes a string with spaces and returns string without any spaces
        String blank = "";
        for (int i = 0; i < un.length(); i++) {
            char c = un.charAt(i);
            //boolean not '!' look for spaces and 'x' and eliminate those characters
            if (!compare(c, new char[]{'x', ' '})) {
                blank += c;
            }
        }
        return blank;
    }

    public static String decryptString(String s, int shift){
        //returns string that will be decrypted
        //undo groupify
        String d = ungroupify(s);
        //undo caesarify
        d = caesarify(d,shift*-1);
        return d;
    }

}

