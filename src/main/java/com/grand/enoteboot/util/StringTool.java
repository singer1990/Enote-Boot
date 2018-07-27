package com.grand.enoteboot.util;

public class StringTool {
    public static String underlineToCamelhump(String inputString) {
        StringBuilder sb = new StringBuilder();

        boolean nextUpperCase = false;
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (c == '_') {
                if (sb.length() > 0) {
                    nextUpperCase = true;
                }
            } else {
                if (nextUpperCase) {
                    sb.append(Character.toUpperCase(c));
                    nextUpperCase = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        return sb.toString();
    }

    public static String camelhumpToUnderline(String inputString) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                sb.append("_").append(Character.toLowerCase(c));
            } else {
                sb.append(Character.toLowerCase(c));

            }
        }
        return sb.toString();
    }
}
