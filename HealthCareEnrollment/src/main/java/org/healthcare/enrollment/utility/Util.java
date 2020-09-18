package org.healthcare.enrollment.utility;

public class Util {

    public static boolean isNotEmpty(String field) {
        return field != null && field.length() != 0;
    }

    public static boolean isEmpty(String field) {
        return field == null || field.length() == 0;
    }
}
