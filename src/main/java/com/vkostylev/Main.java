package com.vkostylev;

public class Main {

    public static void main(String[] args) {
        String[] words = new String[]{
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
                "xenoepist",
                "asymptote",  // <-- rotates here!
                "babka",
                "banoffee",
                "engender",
                "karpatka",
                "othellolagkage",
        };
        System.out.println(rotationPointFinder(words));
    }

    //https://www.interviewcake.com/question/java/find-rotation-point
    public static int rotationPointFinder(String[] words) {
        String previous = words[0];
        for (int i = 1; i < words.length; i++) {
            if (words[i].compareTo(previous) < 0) {
                return i;
            }
            previous = words[i];
        }
        return -1;
    }

    public static String reverse(String string) throws IllegalArgumentException {
        if (string == null) throw new IllegalArgumentException("Provided string is null");
        int l = string.length();
        char[] charsIn = new char[l];
        char[] charsOut = new char[l];
        string.getChars(0, l, charsIn,0);
        for (int i = l-1, j = 0; i >= 0; i--, j++) {
            charsOut[i] = charsIn[j];
        }
        String result = new String(charsOut);
        return result;
    }
}
