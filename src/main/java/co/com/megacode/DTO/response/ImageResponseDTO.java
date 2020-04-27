package co.com.megacode.DTO.response;

import co.com.megacode.util.JsonPropertiesName;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageResponseDTO {

    @JsonProperty(value = JsonPropertiesName.PATH, required = true , access = JsonProperty.Access.READ_ONLY)
    private String path;

    @JsonProperty(value = JsonPropertiesName.TITLE_IMAGE, required = true , access = JsonProperty.Access.READ_ONLY)
    private String titleImage;

    @JsonProperty(value = JsonPropertiesName.COMMENTS_IMAGE, required = true , access = JsonProperty.Access.READ_ONLY)
    private String commentsImage;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
