package co.com.megacode.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static co.com.megacode.constant.Constant.REGULAR_EXPRESSION_EMAIL;
import static co.com.megacode.constant.Constant.MINUMUN_CHARACTERS_PASSWORD;
import static co.com.megacode.constant.Constant.REGEX_PATTERNS;

public class FormatUtil {

    public static boolean validateFormatEmail(String email){

        Pattern pattern = Pattern.compile( REGULAR_EXPRESSION_EMAIL );

        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static boolean validateFormatPassword(String password) {

        if(password.length() < MINUMUN_CHARACTERS_PASSWORD)
            return false;

        for(Pattern pattern : REGEX_PATTERNS){
            if(!pattern.matcher(password).matches()){
                return false;
            }
        }

        return true;
    }
}
