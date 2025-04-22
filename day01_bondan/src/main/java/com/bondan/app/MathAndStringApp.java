package com.bondan.app;

import com.bondan.challenge.MathAndString;

public class MathAndStringApp {
    public static void main(String[] args) {
        MathAndString mathAndString = new MathAndString();
        System.out.println(mathAndString.reverseNumber(4563));
        System.out.println(mathAndString.isPalindrome(2147447412));
        System.out.println(mathAndString.isPalindrome(110));
        System.out.println(mathAndString.capitalize("this is a very special title"));
        System.out.println(mathAndString.capitalize("effective java is great"));
        System.out.println(mathAndString.isNoDuplicateChar("codeid"));
        System.out.println(mathAndString.isNoDuplicateChar("abcde"));
        System.out.println(mathAndString.isBrace("(())"));
        System.out.println(mathAndString.isBrace("()()"));
        System.out.println(mathAndString.isBrace("((()"));
        System.out.println(mathAndString.isBrace("())("));
    }
}
