package com.mac.hiddenmessages.utils;


public class MsgParser {
    public static String algorithm1(String input) {
        StringBuilder output = new StringBuilder("");
        String[] sentence = input.split(" ");
        boolean capitalize = true;
        for (String word : sentence) {
            if(word.length() > 0) {
                if (capitalize) {
                    capitalize = false;
                    output.append(Character.toUpperCase(word.charAt(0)));
                } else {
                    output.append(word.charAt(0));
                }

                if (word.contains(",")) {
                    output.append(" ");
                    capitalize = true;
                }
            }

        }
        return output.toString();
    }

    public static String algorithm2(String input) {
        StringBuilder output = new StringBuilder("");
        String[] sentence = input.split(" ");
        if (sentence.length > 0) {
            String firstWord = sentence[0];
            int key = firstWord.length();

            for (int i = 1; i < sentence.length; i++) {
                String word = sentence[i];
                if (word.length() < key) {
                    output.append(" ");
                } else {
                    output.append(word.charAt(key - 1));
                }
            }
            return output.toString();
        }
        return "";
    }
}
