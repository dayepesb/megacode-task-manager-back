package co.com.megacode.constant;

import static co.com.megacode.constant.UrlName.*;

public class JwtConstant {

    public static final String ID_CLAIMS_MAP = "ID";

    public static final Long TIME_MS_EXPIRATION_TOKEN = 5*60*60*1000L;

    public static final Long CONFIRM_USER_TIME_MS_EXPIRATION_TOKEN = 2*60*60*1000L;

    public static final String [] URL_WITHOUT_AUTHENTICATION =  new String[] {
            concat(URL_FILES,URL_SAVE_IMG_GENERAL),
            concat(URL_IMAGES, URL_IMAGES_PRINCIPAL_PAGE),
            concat(URL_LABELS, URL_LABELS_BY_APP),
            concat(URL_USER, URL_REGISTER_USER),
            concat(URL_USER, URL_LOGIN),
            concat(URL_USER, URL_VERIFY_USER),
            concat(URL_USER, URL_RESEND_VERIFY_USER),
            concat(URL_USER, URL_VERIFY_TOKEN)
    };

    private static String concat (String ... urls){
        StringBuilder sb = new StringBuilder();
        for (String url:urls) {
            sb.append(url);
        }
        return sb.toString();
    }

}
