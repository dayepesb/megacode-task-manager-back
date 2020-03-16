package co.com.megacode.DTO;

import co.com.megacode.util.JsonPropertiesName;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageDTO {

    @JsonProperty(value = JsonPropertiesName.IMAGE_B64, required = true , access = JsonProperty.Access.READ_ONLY)
    private String imageB64;

    @JsonProperty(value = JsonPropertiesName.TITLE_IMAGE, required = true , access = JsonProperty.Access.READ_ONLY)
    private String titleImage;

    @JsonProperty(value = JsonPropertiesName.COMMENTS_IMAGE, required = true , access = JsonProperty.Access.READ_ONLY)
    private String commentsImage;

    public String getImageB64() {
        return imageB64;
    }

    public void setImageB64(String imageB64) {
        this.imageB64 = imageB64;
    }

    public String getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public String getCommentsImage() {
        return commentsImage;
    }

    public void setCommentsImage(String commentsImage) {
        this.commentsImage = commentsImage;
    }
}
