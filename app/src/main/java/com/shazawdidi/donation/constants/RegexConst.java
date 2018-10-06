package com.shazawdidi.donation.constants;

/**
 * Created by shazalia on Sep, 2018
 */
final public class RegexConst {
    private RegexConst() {
    }

    public final static String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
}
